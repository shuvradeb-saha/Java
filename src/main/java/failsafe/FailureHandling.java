package failsafe;

import dev.failsafe.CircuitBreaker;
import dev.failsafe.Failsafe;
import dev.failsafe.RetryPolicy;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FailureHandling {

  public static void main(String[] args) {
    AtomicInteger integer = new AtomicInteger(6);
    AtomicLong time = new AtomicLong();

    var cb =
        CircuitBreaker.builder()
            .withDelay(Duration.of(500, ChronoUnit.MILLIS))
            .withFailureThreshold(4, 7)
            .withSuccessThreshold(3, 5)
            .onClose(event -> {})
            .onOpen(event -> {})
            .onHalfOpen(event -> {})
            .handle(RuntimeException.class)
            .build();

    var rp =
        RetryPolicy.builder()
            .onRetriesExceeded(
                event -> {
                  log.info(
                      "Exceeded: {}, {}", event.getResult(), event.getException().getMessage());
                })
            .onRetry(
                event -> {
                  log.info(
                      "Retrying... Attempt count: {}. Error: {} Time: {}",
                      event.getAttemptCount(),
                      event.getLastException().getMessage(),
                      System.currentTimeMillis());
                  if (event.getAttemptCount() > 1) {
                    log.info("Retrying after: {} millis", System.currentTimeMillis() - time.get());
                  }

                  if (event.getAttemptCount() == 2) {
                    integer.set(2);
                  }

                  time.set(System.currentTimeMillis());
                })
            .withMaxRetries(5)
            .withBackoff(500, 2000, ChronoUnit.MILLIS, 2.0)
            .build();

    Failsafe.with(rp, cb)
        .onComplete(
            objectExecutionCompletedEvent -> {
              log.info("Completed");
            })
        .onSuccess(
            objectExecutionCompletedEvent -> {
              log.info("Success");
            })
        .onFailure(
            objectExecutionCompletedEvent -> {
              log.info("Failure");
            })
        .run(
            () -> {
              if (integer.get() > 5) {
                throw new RuntimeException("Error");
              }
              log.info("Testing with failsafe");
            });
  }
}

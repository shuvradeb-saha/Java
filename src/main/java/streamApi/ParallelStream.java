package streamApi;

import com.google.common.base.Stopwatch;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;

/**
 * Parallel stream divide the list of tasks into multiple chunks and process in different threads.
 */
@Slf4j
public class ParallelStream {
  // 18033, 17323,
  // 249234, 246814
  public static void main(String[] args) {
    // ExecutorService executorService = Executors.newSingleThreadExecutor();
    AtomicInteger counter = new AtomicInteger(0);
    CompletableFuture.runAsync(
            () -> {
              Stopwatch stopwatch = Stopwatch.createStarted();
              IntStream.range(1, 1000)
                  .parallel()
                  .forEach(
                      value -> {
                        try {
                          Random random = new Random();
                          Thread.sleep(random.nextInt(1, 5) * 100L);
                          log.info(String.valueOf(value));
                          counter.incrementAndGet();
                        } catch (InterruptedException e) {
                          throw new RuntimeException(e);
                        }
                      });

              log.info("Time Parallel: {} ms", stopwatch.elapsed(TimeUnit.MILLISECONDS));
            })
        .join();

    //    CompletableFuture.runAsync(() -> {
    //      IntStream.range(1,5).forEach(v->log.info("{}", v));
    //    }).join();

    log.info("finished! {}", counter.get());
  }
}

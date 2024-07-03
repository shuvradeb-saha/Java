package thread.future;

import java.util.concurrent.*;

public class FutureObj {
  public static void main(String[] args) {
    var ex = Executors.newSingleThreadExecutor();
    var future =
        ex.submit(
            () -> {
              try {
                Thread.sleep(2000);
                return 100;
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            });

    try {
      Integer in = future.get(10, TimeUnit.MINUTES);
      if (future.isDone()) {
        System.out.println(in);
      } else {
        System.out.println("Not done");
      }
    } catch (InterruptedException | ExecutionException | TimeoutException e) {
      throw new RuntimeException(e);
    } finally {
      ex.shutdown();
    }
  }
}

package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @created 6/5/23
 * @author Shuvradeb
 */
public class TestExec {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.submit(
        () -> {
          System.out.println(Thread.currentThread().getName() + "_task1");
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        });
    executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "_task2"));

    System.out.println("Next");

    executorService.shutdown();
  }
}

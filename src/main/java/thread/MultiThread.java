package thread;

import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThread {
  ExecutorService executorService = Executors.newFixedThreadPool(32);

  public Integer executeAndReturn() {

    AtomicInteger shared = new AtomicInteger(0);

    executorService.submit(
        () -> {
          System.out.println("Thread: " + Thread.currentThread().getName());
          shared.set(15);
        });

    Future<Integer> a = executorService.submit(shared::get);
    try {
      Future<Integer> b =
          executorService.submit(
              () -> {
                Thread.sleep(4000);
                return 22;
              });
      executorService.shutdown();
      Integer av = a.get();
      Integer bv = b.get();
      return av + bv;
    } catch (InterruptedException | ExecutionException e) {
      return null;
    }
  }

  public void testAsync() {
    executorService.submit(
        () -> {
          try {
            Thread.sleep(0);
            System.out.println("Thread " + Thread.currentThread().getName() + "has been woken up");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        });
    executorService.shutdown();
    System.out.println("Executed");
  }

  public static void main(String[] args) {
    MultiThread multiThread = new MultiThread();
    int a = multiThread.executeAndReturn();
    System.out.println("A = " + a);

    // multiThread.testAsync();
  }
}

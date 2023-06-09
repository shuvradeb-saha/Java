package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreLock {
  ReentrantLock reentrantLock = new ReentrantLock(true);
  Semaphore semaphore = new Semaphore(1);
  public int sum = 10;

  private final ExecutorService executorService = Executors.newFixedThreadPool(4);

  public void test() {
    executorService.submit(this::increase);
    executorService.submit(this::increase);
    executorService.submit(this::increase);

    executorService.shutdown();
  }

  public static void main(String[] args) {
    SemaphoreLock s = new SemaphoreLock();
    s.test();
  }

  public void increase() {
    // reentrantLock.lock();
    try {
      semaphore.acquire();
      sum += 5;
      System.out.println(Thread.currentThread().getName() + " = " + sum);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      semaphore.release();
      // reentrantLock.unlock();
    }
  }
}

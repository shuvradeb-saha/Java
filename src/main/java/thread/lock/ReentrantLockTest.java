package thread.lock;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @created 6/6/23
 * @author Shuvradeb
 */
public class ReentrantLockTest {
  ReentrantLock lock = new ReentrantLock();
  private static int salary = 10_000;

  private void decrement() {
    try {
      if (lock.tryLock(1, TimeUnit.SECONDS)) {
        salary -= 500;
        System.out.println(
            "HoldCount: " + lock.getHoldCount() + " Thread: " + Thread.currentThread().getName());
      }
    } catch (InterruptedException ignore) {

    } finally {
      if (lock.isLocked() && lock.isHeldByCurrentThread()) {
        lock.unlock();
      }
    }
  }

  private void increment() {
    try {
      if (lock.tryLock(1, TimeUnit.SECONDS)) {
        System.out.println("Acquired lock for: " + Thread.currentThread().getName());
        salary += 1000;
        System.out.println("Salary after increment: " + salary);

//        ExecutorService executor = Executors.newFixedThreadPool(2);
//        Future<?> task = executor.submit(this::decrement);
//
//        if(task.isDone()) {
//          System.out.println("Done!");
//        }
//
//        executor.shutdown();
        // decrement();
        System.out.println("Salary final: " + salary);
      } else {
        System.out.println("Unable to acquire lock for: " + Thread.currentThread().getName());
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      if (lock.isLocked() && lock.isHeldByCurrentThread()) {
        lock.unlock();
      }
    }
  }

  public static void main(String[] args) {
    ReentrantLockTest lockTest = new ReentrantLockTest();
    ExecutorService executor = Executors.newFixedThreadPool(5);

    executor.execute(lockTest::increment);
    executor.execute(lockTest::increment);
    executor.execute(lockTest::increment);
    executor.execute(lockTest::increment);
    executor.execute(lockTest::increment);

    executor.shutdown();
  }
}

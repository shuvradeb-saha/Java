package elapsedtime;

import com.google.common.base.Stopwatch;

/**
 * @created 6/9/23
 * @author Shuvradeb
 */
public class GoogleStopwatch {

  public static void main(String[] args) throws InterruptedException {
    Stopwatch stopwatch = Stopwatch.createStarted();
    Thread.sleep(1000);
    System.out.println(stopwatch.stop());
    stopwatch.reset();
    stopwatch.start();
    Thread.sleep(2000);
    System.out.println(stopwatch.stop().toString());
    stopwatch.elapsed();
  }
}

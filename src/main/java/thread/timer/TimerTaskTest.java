package thread.timer;

import java.util.TimerTask;

/**
 * @author Shuvradeb
 * @created 8/31/23
 */
public class TimerTaskTest extends TimerTask {
    private static int counter = 1;

    @Override
    public void run() {
        System.out.println("Hello  from" + Thread.currentThread().getName());
        counter++;
        if (counter == 10) {
            System.out.println("Stopping task!!");
            super.cancel();
        }
    }
}

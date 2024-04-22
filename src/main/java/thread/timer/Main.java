package thread.timer;

import java.util.Timer;

/**
 * @author Shuvradeb
 * @created 8/31/23
 */
public class Main {

    public static void main(String[] args) {
        TimerTaskTest timerTaskTest = new TimerTaskTest();
        Timer timer= new Timer();
        timer.schedule(timerTaskTest, 100, 100);
        timer.cancel();
    }
}

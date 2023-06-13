package collections.deque;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * @author Shuvradeb
 * @created 6/13/23
 */
public class SynchronousQueueTest {
    private static final SynchronousQueue<Integer> syncQueue = new SynchronousQueue<>(true);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Producer
        executor.submit(() -> {
            try {
                syncQueue.put(1);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        // Consumer
        executor.submit(() -> {
            Integer i = null;
            try {
                Thread.sleep(1000);
                i = syncQueue.take();
                // syncQueue.take();
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // syncQueue.remove();
        // syncQueue.add(2);

        executor.shutdown();
    }

}

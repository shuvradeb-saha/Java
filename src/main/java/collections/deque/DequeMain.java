package collections.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Shuvradeb
 * @created 4/3/23
 */
public class DequeMain {

  public static void main(String[] args) {
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(1);
    deque.add(2);
    deque.addFirst(3);
    deque.addLast(4);

    System.out.println(deque);
    var data = deque.pop();
    System.out.println("Popped: " + data);
    System.out.println(deque);
  }
}

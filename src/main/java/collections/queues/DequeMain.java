package collections.queues;

import lombok.val;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class DequeMain {

  public static void main(String[] args) {
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(2);
    deque.add(1);
    deque.add(3);
    System.out.println(deque);

    deque.addLast(6);
    deque.addFirst(6);
    System.out.println(deque);

    ArrayList<Integer> arrayList = new ArrayList<>(deque);
    System.out.println(arrayList);
  }
}

package collections;

import java.util.List;

public class SpreadOperations {

  public static void spreadTest(Integer... ints) {
    System.out.println(ints.getClass().getSimpleName());
  }

  public static void main(String[] args) {
    spreadTest(1);
    spreadTest(2, 3, 4);
    spreadTest(List.of(1, 2, 3, 4).toArray(Integer[]::new));
  }
}

package new17;

import java.util.Random;

public class SwitchTest {

  public static void main(String[] args) {
    Random r = new Random();

    int a = 5 % r.nextInt();

    switch (a) {
      case 1 -> System.out.println(a);
      case 2 -> System.out.println(a);
      case 3 -> System.out.println(a);
      case 4 -> System.out.println(a);
      default -> {
        System.out.println("Hello");
        System.out.println(a);
      }
    }

    long total = 50, currentCount = 25;
    double progress = (25 * 1.0) / 50;
    System.out.println("Progress: " + progress);
  }
}

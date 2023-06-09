package lamda;

import java.util.function.Consumer;

public class LambdaTest {

  public static void test(String id, Consumer<String> consumer) {
    consumer.accept(id);
  }

  public static void consumerTest() {
    test(
        "1",
        (id) -> {
          System.out.println("Came here");
          System.out.println("Hello " + id);
          test(
              "2",
              (id2) -> {
                System.out.println("Came inner");
                System.out.println("Hello inner" + id2);
              });
        });
  }

  public static void main(String[] args) {
    consumerTest();
  }
}

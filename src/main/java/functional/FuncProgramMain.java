package functional;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @created 5/24/23
 * @author Shuvradeb
 */
public class FuncProgramMain {

  private static void test(Function<Integer, Integer> func) {
    int res = func.apply(10);
    Consumer<Integer> consumer = System.out::println;
    consumer.accept(res);
  }

  public static void main(String[] args) {
    Function<Integer, Integer> square = x -> x * x;

    var func =
        square
            .andThen(integer -> integer + 2)
            .andThen(
                integer -> {
                  System.out.println(integer);
                  return 0;
                });

    test(func);
    // func.apply(4);
  }
}

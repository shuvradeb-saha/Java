package streamApi;

import java.util.Arrays;

/**
 * @created 6/9/23
 * @author Shuvradeb
 */
public class StreamToArray {
  public static void main(String[] args) {
    var orders = DuplicateFinder.orders();

    String[] users = orders.stream().map(DuplicateFinder.Order::getUserId).toArray(String[]::new);
    System.out.println(Arrays.toString(users));
  }
}

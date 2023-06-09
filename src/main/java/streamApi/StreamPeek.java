package streamApi;

/**
 * @created 6/5/23
 * @author Shuvradeb
 */
public class StreamPeek {

  public static void main(String[] args) {
    var orders = DuplicateFinder.orders();
    orders.stream()
        .peek(
            order -> {
              order.setItemCount(4);
            })
        .forEach(System.out::println);
  }
}

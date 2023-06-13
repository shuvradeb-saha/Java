package streamApi;

import static java.util.stream.Collectors.counting;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @created 6/2/23
 * @author Shuvradeb
 */
public class DuplicateFinder {
  private static Integer count = 1;

  public static List<Order> orders() {
    var orders = new ArrayList<Order>();
    orders.add(order(12, 3));
    orders.add(order(12, 3));
    orders.add(order(12, 3));

    orders.add(order(21, 3));

    orders.add(order(22, 3));

    orders.add(order(23, 3));
    orders.add(order(23, 4));

    return orders;
  }

  private static Order order(Integer uid, Integer count) {
    return new Order().setOrderId(count++).setUserId(uid.toString()).setItemCount(count);
  }

  public static void main(String[] args) {

    var data = orders().stream().collect(Collectors.groupingBy(Function.identity(), counting()));
    System.out.println(data);

    var dataWithGreaterThanOne =
        data.entrySet().stream()
            .filter(entry -> entry.getValue() > 1)
            // .flatMap(entry -> nCopies(entry.getValue().intValue(), entry.getKey()).stream())
            .toList();

    System.out.println(dataWithGreaterThanOne);
  }

  public static class Order {
    private Integer orderId;
    private String userId;
    private Integer itemCount;

    public Integer getOrderId() {
      return orderId;
    }

    public Order setOrderId(Integer orderId) {
      this.orderId = orderId;
      return this;
    }

    public String getUserId() {
      return userId;
    }

    public Order setUserId(String userId) {
      this.userId = userId;
      return this;
    }

    public Integer getItemCount() {
      return itemCount;
    }

    public Order setItemCount(Integer itemCount) {
      this.itemCount = itemCount;
      return this;
    }

    @Override
    public String toString() {
      return "Order{"
          + "orderId="
          + orderId
          + ", userId="
          + userId
          + ", itemCount="
          + itemCount
          + '}';
    }
  }
}

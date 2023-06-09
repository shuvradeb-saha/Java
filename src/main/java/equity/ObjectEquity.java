package equity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @created 5/8/23
 * @author Shuvradeb
 */
public class ObjectEquity {

  public static void main(String[] args) {
    Map<String, Object> data = new HashMap<>();
    data.put("app", "abc");

    System.out.println(Objects.equals("abc", data.get("app"))); // It works

  }
}

package map;

import java.util.HashMap;
import java.util.Map;

public class NullKeyValue {

  public static void main(String[] args) {
    Map<String, Integer> m = new HashMap<>();
    m.put("a", 1);
    m.put("b", null);

    m.remove("a");
    System.out.println(m);

    // System.out.println(m.get("ABC"));

    //    System.out.println(m.toString());

    double v = 3.1416;
    Integer i = -1;
    long vl = (long) (i < 0 ? v : i);

    System.out.println(vl);
  }
}

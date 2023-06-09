package map;

import java.util.*;

/**
 * @created 5/31/23
 * @author Shuvradeb
 */
public class MapFunctions {
  private static Map<Integer, List<String>> map = new HashMap<>();

  private static void put(int key) {
    if (map.containsKey(key)) {
      map.computeIfPresent(
          key,
          (integer, strings) -> {
            strings.add(String.valueOf(integer * 2));
            return strings;
          });
    } else {
      var lst = new ArrayList<String>();
      lst.add("a");
      map.put(key, lst);
    }
  }

  public static void main(String[] args) {
    put(3);
    put(4);
    put(4);

    System.out.println(map);
  }
}

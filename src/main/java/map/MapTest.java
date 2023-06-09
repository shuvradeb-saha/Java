package map;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * <li>HashMap: HashMap is the implementation of Map, but it doesn't maintain any order.
 * <li>LinkedHashMap: LinkedHashMap is the implementation of Map. It inherits HashMap class. It
 *     maintains insertion order.
 * <li>TreeMap: TreeMap is the implementation of Map and SortedMap. It maintains ascending order.
 */
public class MapTest {
  private static Logger log = Logger.getLogger(MapTest.class.getName());

  public static void main(String[] args) {
    Map<Integer, String> hashMap = new HashMap<>();
    hashMap.put(5, "five");
    hashMap.put(3, "three");
    hashMap.put(6, "six");
    hashMap.put(4, "four");

    log.log(Level.INFO, "Print HashMap");
    printMap(hashMap);

    Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
    linkedHashMap.put(5, "five");
    linkedHashMap.put(3, "three");
    linkedHashMap.put(6, "six");
    linkedHashMap.put(4, "four");

    log.log(Level.INFO, "Print LinkedHashMap");
    printMap(linkedHashMap);

    Map<Integer, String> treeMap = new TreeMap<>();
    treeMap.put(5, "five");
    treeMap.put(3, "three");
    treeMap.put(6, "six");
    treeMap.put(4, null);

    log.log(Level.INFO, "Print TreeMap");
    printMap(treeMap);

    System.out.println("Tree Map Should Be Sorted By Key");

    Map<Integer, String> linkedHashMap2 = new LinkedHashMap<>();
    linkedHashMap.put(5, "F i v e");
    linkedHashMap.put(6, "S i x");
    linkedHashMap.put(3, null);
    linkedHashMap.put(15, null);

    linkedHashMap.putAll(linkedHashMap2);
    System.out.println("After");
    linkedHashMap.values().removeAll(Collections.singleton(null));
    // printMap(linkedHashMap);

    // Remove testing
    Map<Integer, String> m = new HashMap<>();
    m.remove(1);
  }

  private static <K, V> void printMap(Map<K, V> map) {
    System.out.println("========= Started Printing ==========");
    for (Map.Entry<K, V> entry : map.entrySet()) {
      System.out.println(String.format("%s - %s", entry.getKey(), entry.getValue()));
    }

    System.out.println("========= Finished Printing ==========\n");
  }
}

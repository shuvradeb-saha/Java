package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Found discrepancy while deserializing a List created using Arrays.asList() and
 * Arrays.stream().toList()
 *
 * @author Shuvradeb
 * @created 4/5/23
 */
public class ArrayMain {
  static Logger LOG = Logger.getLogger(ArrayMain.class.getName());

  public static void main(String[] args) {

    Integer[] intArray = new Integer[] {2, 3};

    List<Integer> intList = Arrays.asList(intArray); // This is the ArrayList object which is a private class in Arrays
    System.out.println(intList.getClass().getName());

    List<Integer> intList2 = Arrays.stream(intArray).toList();
    System.out.println(intList2.getClass().getName());
  }
}

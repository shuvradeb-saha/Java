package collections.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetDS {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(1);
    list.add(3);



    Set<Integer> genSet = list.stream().map(integer -> integer * 2).collect(Collectors.toSet());
    System.out.println(genSet);
    //  Set<Integer> set = new HashSet<>(genSet);
    genSet.removeIf(integer -> integer.equals(2));

    System.out.println(genSet);
  }
}

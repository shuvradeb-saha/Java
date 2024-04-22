package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringListToArray {

    public static void main(String[] args) {
        String[] strArray = new String[]{"ShaiShab", "Shuvradeb"};
        List<String> list = new ArrayList<>();
        list.add("ShaiShab");
        list.add("Shuvradeb");

        String[] res = list.toArray(new String[0]);
        System.out.println(Arrays.toString(res));
    }
}

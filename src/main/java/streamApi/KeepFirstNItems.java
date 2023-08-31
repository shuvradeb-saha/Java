package streamApi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shuvradeb
 * @created 6/21/23
 */
public class KeepFirstNItems {
    public static void main(String[] args) {
        var orders = DuplicateFinder.orders();
        //System.out.println(orders.size());
        //System.out.println(orders.stream().limit(13).toList());

        List<Integer> integerList = List.of();
        List<Integer> test = new ArrayList<>();
        test = integerList.stream().filter(i -> i==5).toList();

        System.out.println(test);

    }
}

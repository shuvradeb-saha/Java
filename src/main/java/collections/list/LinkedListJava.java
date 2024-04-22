package collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListJava {

    public static void main(String[] args) {
        var arrayList = new ArrayList<Integer>();
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(1);
        arrayList.add(2);

        printList(arrayList, "arraylist");

        var linkedList = new LinkedList<Integer>();
        linkedList.add(null);
        linkedList.add(2);
        linkedList.add(3);

        printList(linkedList, "linkedList");
    }

    private static void printList(List<Integer> intList, String name) {
        System.out.printf("<<<Printing: %s. Size: %d >>>\n", name, intList.size());
        for (Integer integer : intList) {
            System.out.println(integer);
        }
    }
}


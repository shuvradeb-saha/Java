package math;

import java.util.List;

public class Modulo {
  public static void main(String[] args) {
    var list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
    int size = 23;
    int chunkSize = 50;
    var totalChunk = size / chunkSize;

    int index = 0, listSize = list.size();
    while (index < list.size()) {
      var chunk = Math.min(index + chunkSize, listSize);
      System.out.println("Index: %d Chunk: %d".formatted(index, chunk));
      var sub = list.subList(index, chunk);
      System.out.println("Sublist: " + sub.size() + " " + sub);
      index += chunkSize;
    }

    System.out.println(totalChunk);
  }
}

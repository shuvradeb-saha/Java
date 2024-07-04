package io.filemanagement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVGenerator {

  public static void generateCsvFile(String filePath, List<User> users) {
    try (FileWriter writer = new FileWriter(filePath)) {
      // Writing header
      writer.append("userId,userName\n");

      // Writing data
      for (User user : users) {
        writer
            .append(String.valueOf(user.getId()))
            .append(',')
            .append(user.getUserName())
            .append('\n');
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

package io.filemanagement;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import com.google.common.io.Files;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;

public class ObjectToCSV {

  public static void main(String[] args) {
    List<User> users =
        Stream.of("shuvradeb", "shaishab", "nipa")
            .map(
                s -> {
                  var user = new User();
                  user.setUserName(s);
                  return user;
                })
            .toList();
    try {
      CSVGenerator.generateCsvFile("user.csv", users);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    for (var user : users) {}
  }
}

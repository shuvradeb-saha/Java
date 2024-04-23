package timeanddate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DateWithTZ {

  public static void main(String[] args) {
    var PATTERNS = new ArrayList<String>();
    // 2024-04-23T15:56:01800+0600
    PATTERNS.add("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    // 2024-04-23T15:56:01+0600
    PATTERNS.add("yyyy-MM-dd'T'HH:mm:ssZ");
    // To support the char Z inside the date
    // 2024-04-23T15:56:01Z
    PATTERNS.add("yyyy-MM-dd'T'HH:mm:ssX");

    String dateString = "2024-04-23T15:56:01.800+0600";
    boolean success = false;
    for (var pattern : PATTERNS) {
      try {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        System.out.println(sdf.parse(dateString));
        success = true;
      } catch (ParseException ignored) {
      }
    }

    if (!success) {
      System.out.println("\u001B[31mFailed to parse date: " + dateString);
    }
  }
}

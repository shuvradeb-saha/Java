package streamApi;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CheckNullStaff {

  public static void main(String[] args) throws MalformedURLException {
    List<String> list = List.of("saha", "shaishab", "shuvra");
    List<String> newString =
        list.stream()
            .map(s -> s.equals("saha") ? null : s + " extra")
            .filter(Objects::nonNull)
            .toList();

    //System.out.println("New: " + newString.toString());

    var referer = "https://abc.ntb-it.com/def";
    var rURL = new URL(referer);
    var refHost = rURL.getHost();
    System.out.println(refHost);

    var VALID_DOMAINS = Arrays.asList("ntb.no", "ntb-it.com");
    boolean isValidDomain = VALID_DOMAINS.stream().anyMatch(refHost::endsWith);
    System.out.println("IsValid DOmain " + isValidDomain);
  }
}

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
  private static List<Integer> getInts() {
    log.info("Getting integers");
    return IntStream.range(1, 11).boxed().toList();
  }

  public static void main(String[] args) {
    //    System.out.println(getInts().size());
    //    System.out.println(getInts().subList(0, 10).size());
    //    var list = getInts().subList(0, 10);
    //    for (int j = 0; j < list.size(); j++) {
    //      System.out.println(j);
    //    }

    //    Set<User> users =
    //        Set.of(new User(11, "shaishab"), new User(12, "shuvra"), new User(13, "Krishna"));
    //    String us = userToString(users);
    System.out.println(System.currentTimeMillis() + 1);
  }

  private static String userToString(Set<User> users) {
    return users.stream()
        .map(user -> String.format("%d:%s", user.getId(), user.getUsername()))
        .collect(Collectors.joining(", "));
  }

  @Data
  @AllArgsConstructor
  private static class User {
    private Integer id;
    private String username;
  }
}

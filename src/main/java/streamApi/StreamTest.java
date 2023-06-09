package streamApi;

import org.apache.commons.exec.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {

  static class Subject {
    String code;
    String name;

    public Subject(String code) {
      this.code = code;
    }

    public Subject(String code, String name) {
      this.code = code;
      this.name = name;
    }

    public String getCode() {
      return code;
    }

    public void setCode(String code) {
      this.code = code;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  public static void main(String[] args) {
    Subject s1 = new Subject("123");
    Subject s2 = new Subject("115", "Saha");
    Subject s3 = new Subject("127", "Nipa");

    List<Subject> subjects = List.of(s1, s2, s3);
    //    List<Subject> subjects = new ArrayList<>();
    long start = System.currentTimeMillis();
    var data = subjects.stream().map(Subject::getName).filter(StreamTest::isNotBlank).toList();
    System.out.println("Took: " + (System.currentTimeMillis() - start));

    long start2 = System.currentTimeMillis();
    data = subjects.parallelStream().map(Subject::getName).filter(StreamTest::isNotBlank).toList();
    System.out.println("Took: " + (System.currentTimeMillis() - start2));

    System.out.println(data.toString());
  }

  private static boolean isNotBlank(final String str) {
    return str != null && !str.trim().equals("");
  }
}

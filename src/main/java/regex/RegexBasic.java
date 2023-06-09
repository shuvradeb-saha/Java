package regex;

import java.io.IOException;

public class RegexBasic {

  /** */
  public void method2() throws IOException {
    throw new IOException("");
  }

  public void method1() throws IOException {
    for (int i = 0; i < 5; i++) {
      if (i == 3) method2();
      System.out.println("came " + i);
    }
  }

  public static void main(String[] args) {
    RegexBasic regexBasic = new RegexBasic();
    try {
      regexBasic.method1();
    } catch (Exception e) {
      System.out.println("Caught exception -> " + e.toString());
    } finally {
      System.out.println("Finish in this block");
    }
  }
}

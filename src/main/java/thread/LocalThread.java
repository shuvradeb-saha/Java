package thread;

import java.util.HashMap;

public class LocalThread {
  private static final ThreadLocal<String> transactionId = new ThreadLocal<>();

  static {
    // transactionId.set("12345");
  }

  public static void main(String[] args) {
    transactionId.remove();
    String s = transactionId.get();
    System.out.println(s);

    try {

      try {
        throw new NullPointerException("Test error");
      } catch (Exception e) {
        throw new RuntimeException(e);
      } finally {
        System.out.println("First finally");
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      System.out.println("Second finally");
    }
  }
}

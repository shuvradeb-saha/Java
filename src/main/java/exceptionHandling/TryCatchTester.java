package exceptionHandling;

public class TryCatchTester {

  public static void main(String[] args) {
    try {
      try {
        throw new RuntimeException(":Throws error");
      } catch (Exception e) {
        throw e;
      } finally {
        System.out.println("Inner finally");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      System.out.println("Outer finally");
    }
  }
}

package anonymous;

/**
 * @author Shuvradeb
 * @created 3/15/23
 */
public class Main {

  /**
   * Anonymous inner class
   *
   * @param args
   */
  public static void main(String[] args) {
    IStudent s =
        new IStudent() {
          @Override
          public String getName() {
            return null;
          }

          @Override
          public String getRoll() {
            return null;
          }
        };

    Student sc =
        new Student() {

          @Override
          public String getDetails() {
            return this.getName() + " Updated";
          }
        };

    sc.setName("Shaishab Saha");
    sc.setRoll("1");

    System.out.println(sc.getDetails());
  }
}

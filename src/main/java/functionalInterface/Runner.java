package functionalInterface;

public class Runner {
  public static void main(String[] args) {
    /*
    * new ITest() {
          @Override
          public void func() {
            System.out.println("hello from functional interface");
          }
        };
    * */
    ITest a = () -> System.out.println("hello from functional interface");
    a.func1();
    a.func();
  }
}

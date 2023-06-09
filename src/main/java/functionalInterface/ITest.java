package functionalInterface;

@FunctionalInterface
public interface ITest {
  public void func();

  default void func1() {
    System.out.println("abc");
  }
}

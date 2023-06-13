package lombok;

import lombok.Data;

/**
 * @created 6/9/23
 * @author Shuvradeb
 */
public class LombokTest {

  public static void main(String[] args) {
    Employee employee = new Employee();
    employee.setName("Shaishab");

    System.out.println(employee.getName());
  }

  @Data
  public static class Employee {
    private String name;
  }
}

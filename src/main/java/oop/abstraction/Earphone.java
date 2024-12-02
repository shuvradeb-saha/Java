package oop.abstraction;

public class Earphone extends Product {
  private final int price = 50;

  @Override
  public Details getDetails() {
    Details details = new Details();
    details.setPrice(calculate(10));
    details.setModel("Samsung Earphone");
    return details;
  }

  @Override
  public int getPrice() {
    return price;
  }
}

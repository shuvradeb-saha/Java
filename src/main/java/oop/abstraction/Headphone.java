package oop.abstraction;

public class Headphone extends Product {
  private final int price = 100;

  @Override
  public Details getDetails() {
    Details details = new Details();
    details.setPrice(calculate(15));
    details.setModel("BOAT HeadPhone");
    return details;
  }

  @Override
  public int getPrice() {
    return price;
  }
}

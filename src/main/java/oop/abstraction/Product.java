package oop.abstraction;

public abstract class Product {
  public abstract int getPrice();

  protected abstract Details getDetails();

  public int calculate(int vat) {
    return getPrice() + vat;
  }
}

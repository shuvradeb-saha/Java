package oop.abstraction;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainSite {

  public static void main(String[] args) {
    Product earphone = new Earphone();
    log.info("Earphone price: {}", earphone.getDetails());

    Product headphone = new Headphone();
    log.info("Headphone price: {}", headphone.getDetails());
  }
}

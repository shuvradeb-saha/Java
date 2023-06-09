package objectReference;

public class RefTester {

  public static void main(String[] args) {
//    ChildObject childObject = new ChildObject();
//    childObject.setName("Shaishab Saha");
//    ParentObject parentObject = new ParentObject();
//    parentObject.setChildObject(childObject);
//
//    System.out.println("Before: " + parentObject.getChildObject().getName());
//
//    checkIfRegWorks(parentObject.getChildObject(), parentObject);
//
//    System.out.println("After: " + parentObject.getChildObject().getName());
//    System.out.println(childObject.toString());

    Boolean test = null;
    if (Boolean.TRUE.equals(test)) {
      System.out.println("HI True");
    } else {
      System.out.println("HI False");
    }
  }

  private static void checkIfRegWorks(ChildObject childObject, ParentObject parentObject) {
    childObject.setName("Suravi Nipa");
  }
}

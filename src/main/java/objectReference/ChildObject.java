package objectReference;

public class ChildObject {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "ChildObject{" + "name='" + name + '\'' + '}';
  }
}

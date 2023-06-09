package annotations;

import java.util.Arrays;

public class CustomAnnotationExample {
  private static final Class<?>[] EMPTY_CLASS_ARRAY = new Class<?>[0];

  public static void main(String[] args) throws NoSuchMethodException {
    System.out.println("Stream");
    Arrays.stream(
            CustomAnnotationExample.class
                .getMethod("getName", EMPTY_CLASS_ARRAY)
                .getDeclaredAnnotations())
        .filter(annotation -> annotation instanceof CustomAnnotation)
        .forEach(
            annotation -> {
              System.out.println(((CustomAnnotation) annotation).age());
              System.out.println(((CustomAnnotation) annotation).name());
            });
  }

  @CustomAnnotation(name = "Shaishab Saha", age = 24)
  public static String getName() {
    return "Shuvra";
  }
}

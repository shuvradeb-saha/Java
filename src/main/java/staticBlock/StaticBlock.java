package staticBlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaticBlock {
  private static final List<String> dateFields;
  private static final List<String> exclusiveFields;

  static {
    exclusiveFields =
        new ArrayList<>(
            List.of(
                "creator",
                "infosource",
                "subjectlocation",
                "subject",
                "renditions",
                "itemmetaextproperty",
                "contributor"));
    dateFields = List.of("sent", "firstcreated", "versioncreated", "contentcreated", "embargoed");
    exclusiveFields.addAll(dateFields);
  }

  /**
   * Arrays.asList(), List.of() these returns immutable/unmodifiable list and add, remove operation
   * is unsupported in them
   */
  public static void main(String[] args) {
    exclusiveFields.forEach(System.out::println);
  }
}

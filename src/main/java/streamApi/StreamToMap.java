package streamApi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Media;

public class StreamToMap {

  public static void main(String[] args) {
    Media media1 = new Media(1, "abc");
    Media media2 = new Media(2, "bcd");
    Media media3 = new Media(1, "def");
    Media media4 = new Media(2, "dfd");

    List<Media> data = List.of(media1, media2, media3, media4);
    Map map =
        data.stream()
            .collect(
                Collectors.groupingBy(
                    Media::getOwner, Collectors.mapping(Media::getMediaId, Collectors.toList())));
    System.out.println(map);
  }
}

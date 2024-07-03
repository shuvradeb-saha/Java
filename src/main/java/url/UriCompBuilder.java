package url;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

public class UriCompBuilder {

  public static void main(String[] args) {
    String domain = "abc.com", path = "test";

    long s = System.currentTimeMillis();
    String.format("https://%s/%s", domain, path);
    System.out.println("Time: " + (System.currentTimeMillis() - s));

    long s2 = System.currentTimeMillis();
    StringBuilder sb = new StringBuilder();
    sb.append("https://");
    sb.append("/").append(domain).append("/").append(path);
    System.out.println("Time: " + (System.currentTimeMillis() - s2));
  }

  public static String url(
      final String baseUrl,
      final String encryptionKey,
      final String objectId,
      final String fileType,
      final Boolean watermark) {
    String toEnc = "p1024";

    toEnc += "." + (BooleanUtils.isTrue(watermark) ? "WATERMARK" : "");
    toEnc = StringUtils.stripEnd(toEnc, ".");

    StringBuilder b = new StringBuilder();
    b.append(baseUrl);
    if (!baseUrl.endsWith("/")) {
      b.append("/");
    }
    b.append(encryptionKey);
    b.append("/");
    b.append(encryptionKey).append(123);
    b.append("/");
    b.append(objectId);
    return b.toString();
  }
}

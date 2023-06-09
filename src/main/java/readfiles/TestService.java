package readfiles;

import lombok.val;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Logger;

public class TestService {
  static Logger log = Logger.getLogger(TestService.class.getName());

  private static File createTestFile() {
    String dir = "/home/shuvradeb/Development/NTB_DOCS/Reuters API/TEST_IMAGE/";
    String fileName =
        "2022-06-05T233415Z_1654475686248_MT1USATODAY18465950_RTRMADP_0_NASCAR-ENJOY-ILLINOIS-300.JSON";
    return new File(dir + fileName);
  }

  public static File createTempFile(final String suggestedExtension) throws IOException {
    return File.createTempFile("aff-", "." + StringUtils.defaultIfBlank(suggestedExtension, "tmp"));
  }

  public static void main(String[] args) throws IOException {
    File json = createTestFile();
    // log.info("Readed File Data: \n {}", FileUtils.readFileToString(json, "UTF-8"));

    File tempFile = null;
    try {
      tempFile = createTempFile("");
      FileUtils.copyToFile(new FileInputStream(json), tempFile);
      URI uri = tempFile.toURI();
      log.info("FileUri: " + uri);
      if (canYouFindFileUsingUri(uri.toString())) {
        log.info("Can read from file uri");
      } else {
        log.info("Unable to read from file uri");
      }

    } catch (Exception e) {
      log.info("Error: " + e);
    } finally {
      //      if (tempFile != null && tempFile.delete()) {
      //        log.info("File cleared!");
      //      }
    }
  }

  private static boolean canYouFindFileUsingUri(final String fileUri) {
    try {
      URL url = new URL(fileUri);
      File file = File.createTempFile("test-1", ".tmp");
      FileUtils.copyURLToFile(url, file);
      log.info("File From Uri: " + file.getName());

      String data = FileUtils.readFileToString(file, "UTF-8");
      log.info("File Content Map: " + data);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}

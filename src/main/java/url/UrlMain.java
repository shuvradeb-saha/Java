package url;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * @author Shuvradeb
 * @created 4/10/23
 */
public class UrlMain {

  public static void main(String[] args) throws MalformedURLException, UnknownHostException {
    String s = "Shaishab/%s/%s/saha";
    System.out.println(String.format(s, "d", "r"));

    String localUrl = "http://localhost:8080/abc/?test=123&another=abc";
    String remoteUrl = "https://abc.ntb.no/test";
    String localIp = "http://127.0.0.1:8080/test";

    URL lUrl = new URL(localUrl);
    URL rUrl = new URL(remoteUrl);
    URL lip = new URL(localIp);

    printUrl(lUrl);
    printUrl(rUrl);
    printUrl(lip);
    System.out.println(InetAddress.getLocalHost().getHostName());
  }

  private static void printUrl(URL url) {
    System.out.println("<<<<  " + url.toString() + " >>>>>");
    System.out.println("Host " + url.getHost());
    System.out.println("Path " + url.getPath());
    System.out.println("Query "+ url.getQuery());
    System.out.println("Port " + url.getPort());
    System.out.println("Default Port " + url.getDefaultPort());
    System.out.println("Protocol " + url.getProtocol());
    System.out.println("Protocol " + url.getAuthority());
    System.out.println("<<< END >>>");
  }
}

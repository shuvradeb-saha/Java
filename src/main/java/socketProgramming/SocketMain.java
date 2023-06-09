package socketProgramming;

import java.io.IOException;

/**
 * @created 6/7/23
 * @author Shuvradeb
 */
public class SocketMain {
  public static void main(String[] args) throws IOException {
    SocketClient socketClient = new SocketClient();

    socketClient.sendMessage("Hi!");
    SocketClient socketClient2 = new SocketClient();
    socketClient2.sendMessage("Hello!");
  }
}

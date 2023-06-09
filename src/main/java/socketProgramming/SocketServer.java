package socketProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Shuvradeb
 * @created 3/16/23
 */
public class SocketServer {

  public static void main(String[] args) throws IOException {
    System.out.println("Server is started");
    ServerSocket serverSocket = new ServerSocket(9999);
    while (true) {

      try {
        System.out.println("Server is waiting for client...");
        Socket socket = serverSocket.accept();
        // without threading
        // rcvMessage(socket);

        // with thread better performance
        new Thread(() -> rcvMessage(socket)).start();

      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      ;
    }
  }

  private static void rcvMessage(Socket socket) {
    try {

      System.out.println("Client connected! " + socket.getInetAddress().getHostName());
      BufferedReader bufferedReader =
          new BufferedReader(new InputStreamReader(socket.getInputStream()));
      String data = bufferedReader.readLine();
      System.out.println(data);
      Thread.sleep(10000);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

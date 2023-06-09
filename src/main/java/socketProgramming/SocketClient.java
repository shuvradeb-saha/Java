package socketProgramming;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Shuvradeb
 * @created 3/16/23
 */
public class SocketClient {
  private final Socket socket;

  public SocketClient() {
    try {
      // 0-1023 are reserved port.
      socket = new Socket("localhost", 9999);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void sendMessage(final String message) throws IOException {
    OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
    PrintWriter writer = new PrintWriter(osw);

    writer.write(message);
    writer.flush();
    socket.close();
  }
}

package commandExec;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellExecution {

  public static void main(String[] args) throws IOException {
    String[] command = {"ping", "www.google.com"};
    ProcessBuilder processBuilder = new ProcessBuilder(command);
    String home = System.getProperty("user.home");
    processBuilder.directory(new File(home));

    BufferedReader reader = null;
    InputStreamReader inputStreamReader = null;

    try {

      Process process = processBuilder.start();
      System.out.println("New Process Started. PID: " + process.pid());

      inputStreamReader = new InputStreamReader(process.getInputStream());
      reader = new BufferedReader(inputStreamReader);
      String line;

      int count = 0;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);

        if (count == 10) {
          break;
        }
        count++;
      }

      process.descendants().forEach(ProcessHandle::destroy);
      process.destroy();
      if (process.isAlive()) {
        System.out.println("The process is still alive...");
        process.destroyForcibly();
        System.out.println("Even after alive: " + process.isAlive());
      }

      System.out.println(process.exitValue());

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        reader.close();
      }

      if (inputStreamReader != null) {
        inputStreamReader.close();
      }
    }
  }
}

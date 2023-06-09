package commandExec;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

public class CommonsExec {
  public static void main(String[] args) throws IOException {
    /* String command = "which java";
    CommandLine commandLine = new CommandLine("which");
    commandLine.addArgument("java");

    DefaultExecutor executor = new DefaultExecutor();
    executor.setWorkingDirectory(new File(System.getProperty("user.home")));
    executor.execute(commandLine);*/

    // String result = run("ping", null, "www.google.com");
    // System.out.println(result);



  }

  public static String run(
      final String cmd, final Map<String, ?> substitutionMap, final String... args)
      throws IOException {
    CommandLine cmdLine = new CommandLine(cmd);
    if (args != null) {
      for (String arg : args) {
        cmdLine.addArgument(arg);
      }
    }
    cmdLine.setSubstitutionMap(substitutionMap);

    DefaultExecutor executor = new DefaultExecutor();
    ExecuteWatchdog watchdog = new ExecuteWatchdog(30000); // if it takes more than 30s..
    executor.setWatchdog(watchdog);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
    executor.setStreamHandler(streamHandler);

    int exitValue = executor.execute(cmdLine);
    String output = outputStream.toString().trim();
    if (exitValue == 0) {
      return output;
    } else {
      // log.warn("`{} {}` returned exit code {}. Output: {}", cmd, args, exitValue, output);
      return null;
    }
  }
}

package cryptography;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

@Slf4j
public class FolderEncryptor {

  private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
  private static Integer fileCounter = 0;

  public static void main(String[] args) {
    try {
      // Specify the folder path and passkey
      String folderPath = "/home/shuvradeb/Desktop/Test_Enc";
      String passkey = "saha";

      // Start encryption
      StopWatch stopWatch = StopWatch.createStarted();
      encryptFolder(folderPath, passkey);
      log.info(
          "Encryption completed. File count: {}. Time: {}",
          fileCounter,
          stopWatch.getTime(TimeUnit.MILLISECONDS));
      stopWatch.stop();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void encryptFolder(String folderPath, String passkey) throws Exception {
    File folder = new File(folderPath);
    if (!folder.exists() || !folder.isDirectory()) {
      throw new IllegalArgumentException("Invalid folder path");
    }

    // Generate a secret key from the passkey
    SecretKey secretKey = generateKeyFromPasskey(passkey);

    // Create an initialization vector (IV)
    byte[] iv = new byte[16]; // 16 bytes for AES
    Arrays.fill(iv, (byte) 0); // Use a predictable IV for simplicity
    IvParameterSpec ivSpec = new IvParameterSpec(iv);

    // Process files recursively
    processFiles(folder, secretKey, ivSpec, false);
    //    try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
    //      executor.submit(
    //          () -> {
    //            log.info("Starting to process files recursively...");
    //            processFiles(folder, secretKey, ivSpec, false);
    //          });
    // }
  }

  @SneakyThrows
  private static void processFiles(
      File folder, SecretKey secretKey, IvParameterSpec ivSpec, boolean encrypt) {
    for (File file : folder.listFiles()) {
      log.info("Processing file: {}", file.getName());
      if (file.isDirectory()) {
        processFiles(file, secretKey, ivSpec, encrypt);
      } else {
        fileCounter++;
        if (encrypt) {
          encryptFile(file, secretKey, ivSpec);
        } else {
          decryptFile(file, secretKey, ivSpec);
        }
      }
    }
  }

  private static void encryptFile(File file, SecretKey secretKey, IvParameterSpec ivSpec)
      throws Exception {
    // Read file content
    byte[] fileData = Files.readAllBytes(file.toPath());

    // Encrypt the file data
    Cipher cipher = Cipher.getInstance(ALGORITHM);
    cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
    byte[] encryptedData = cipher.doFinal(fileData);

    // Write encrypted data back to file
    try (FileOutputStream fos = new FileOutputStream(file)) {
      fos.write(encryptedData);
    }
  }

  private static void decryptFile(File file, SecretKey secretKey, IvParameterSpec ivSpec)
      throws Exception {
    // Read encrypted file content
    byte[] fileData = Files.readAllBytes(file.toPath());

    // Decrypt the file data
    Cipher cipher = Cipher.getInstance(ALGORITHM);
    cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
    byte[] decryptedData = cipher.doFinal(fileData);

    // Write decrypted data back to file
    try (FileOutputStream fos = new FileOutputStream(file)) {
      fos.write(decryptedData);
    }
  }

  private static SecretKey generateKeyFromPasskey(String passkey) throws Exception {
    // Generate a 256-bit key from the passkey
    MessageDigest sha = MessageDigest.getInstance("SHA-256");
    byte[] keyBytes = sha.digest(passkey.getBytes("UTF-8"));
    return new SecretKeySpec(keyBytes, "AES");
  }
}

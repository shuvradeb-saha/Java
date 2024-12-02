package cryptography;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.*;
import java.security.SecureRandom;

public class FileEncryption {
  private static final String ALGORITHM = "AES";
  private static final int KEY_SIZE = 256;

  // Generate a new AES key
  public static SecretKey generateKey() throws Exception {
    KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
    keyGen.init(KEY_SIZE, new SecureRandom());
    return keyGen.generateKey();
  }

  // Save the AES key to a file
  public static void saveKey(SecretKey key, String filePath) throws IOException {
    byte[] keyBytes = key.getEncoded();
    Files.write(Paths.get(filePath), keyBytes);
  }

  // Load the AES key from a file
  public static SecretKey loadKey(String filePath) throws IOException {
    byte[] keyBytes = Files.readAllBytes(Paths.get(filePath));
    return new SecretKeySpec(keyBytes, ALGORITHM);
  }

  // Encrypt a file
  public static void encryptFile(SecretKey key, File inputFile, File outputFile) throws Exception {
    Cipher cipher = Cipher.getInstance(ALGORITHM);
    cipher.init(Cipher.ENCRYPT_MODE, key);

    try (FileInputStream fis = new FileInputStream(inputFile);
        FileOutputStream fos = new FileOutputStream(outputFile);
        CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
      byte[] buffer = new byte[1024];
      int read;
      while ((read = fis.read(buffer)) != -1) {
        cos.write(buffer, 0, read);
      }
    }
  }

  // Decrypt a file
  public static void decryptFile(SecretKey key, File inputFile, File outputFile) throws Exception {
    Cipher cipher = Cipher.getInstance(ALGORITHM);
    cipher.init(Cipher.DECRYPT_MODE, key);

    try (FileInputStream fis = new FileInputStream(inputFile);
        CipherInputStream cis = new CipherInputStream(fis, cipher);
        FileOutputStream fos = new FileOutputStream(outputFile)) {
      byte[] buffer = new byte[1024];
      int read;
      while ((read = cis.read(buffer)) != -1) {
        fos.write(buffer, 0, read);
      }
    }
  }

  // Recursively encrypt/decrypt a folder
  public static void processFolder(SecretKey key, File folder, boolean encrypt) throws Exception {
    File[] files = folder.listFiles();
    if (files != null) {
      for (File file : files) {
        if (file.isDirectory()) {
          processFolder(key, file, encrypt);
        } else {
          File outputFile =
              new File(file.getParent(), (encrypt ? "enc_" : "dec_") + file.getName());
          if (encrypt) {
            encryptFile(key, file, outputFile);
          } else {
            decryptFile(key, file, outputFile);
          }
          System.out.println((encrypt ? "Encrypted" : "Decrypted") + ": " + file.getAbsolutePath());
        }
      }
    }
  }

  public static void main(String[] args) {
    try {
      String keyFilePath = "/home/shuvradeb/encryption_key.key";
      String folderPath = "/home/shuvradeb/test_folder";

      // Step 1: Generate and save a key
      SecretKey secretKey = generateKey();
      saveKey(secretKey, keyFilePath);

      // Step 2: Load the key
      SecretKey loadedKey = loadKey(keyFilePath);

      // Step 3: Encrypt the folder
      File folder = new File(folderPath);
      System.out.println("Encrypting folder...");
      processFolder(loadedKey, folder, true);

      // Step 4: Decrypt the folder
      //      System.out.println("Decrypting folder...");
      //      processFolder(loadedKey, folder, false);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

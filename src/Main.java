import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class Main {
    private static String key = " ";
    private static SecretKey secretKey = null;
    private static String message = " ";
    private static MessageEncryption cipher = CipherFactory.getCipherMethod("AES");

    private static final String commandList = "Command list: \n1 - Set cipher\n2 - Generate new key\n" +
            "3 - Enter key\n4 - Enter message\n5 - Encrypt\n6 - Decrypt\ninfo\nexit\n";

    public static void main(String[] args) {

        boolean isFinished = false;
        printer("first");
        printer("list");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!isFinished) {
                String command = reader.readLine();
                if (command == null)
                    break;
                switch (command) {
                    case "1":
                        //set encryption type, AES by default
                        cipher = CipherFactory.getCipherMethod(reader.readLine());
                        printer("info");
                        break;
                    case "2":
                        //generate new key
                        secretKey = RandomKeyGenerator.getRandomKey(cipher.getCipherType());
                        key = secretKeyToString();
                        printer("info");
                        break;
                    case "3":
                        key = reader.readLine();
                        secretKey = stringToSecretKey();
                        printer("info");
                        break;
                    case "4":
                        //enter message
                        message = reader.readLine();
                        printer("info");
                        break;
                    case "5":
                        //encrypt
                        message = cipher.encryptMessage(message, secretKey);
                        printer("info");
                        break;
                    case "6":
                        //decrypt
                        message = cipher.decryptMessage(message, secretKey);
                        printer("info");
                        break;
                    case "info":
                        printer("info");
                        break;
                    case "exit":
                        return;
                    default:
                        printer("list");
                        break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printer(String command) {
        switch (command) {
            case "first":
                System.out.println("Possible ciphers - AES, Blowfish, Vigenere");
                break;
            case "info":
                System.out.printf("Cipher - %s\nKey - %s\nmessage - %s\n", cipher.getCipherType(), key, message);
                break;
            case "list":
                System.out.println(commandList);
                break;
        }
    }


    public static SecretKey stringToSecretKey() {
        try {
            byte[] decodedKey = Base64.getDecoder().decode(key);
            return new SecretKeySpec(decodedKey, 0, decodedKey.length, cipher.getCipherType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String secretKeyToString() {
        try {
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String getStringFromFile() {
        File file = new File("D:\\мами\\result.txt");
        StringBuffer sb = new StringBuffer();
        try (FileInputStream fis = new FileInputStream(file)) {
            int b;
            while ((b = fis.read()) != -1) { //чтение
                sb.append((char) b);
            }
            return new String(sb);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}

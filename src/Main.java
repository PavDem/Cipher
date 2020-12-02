import cipher.CipherDoesNotExist;
import cipher.MessageEncryption;

import java.io.*;
import java.util.Optional;

public class Main {
    private static MessageEncryption cipher = CipherFactory.getCipherType("AES");
    private static String message = " ";
    private static String key = " ";
    private static final String commandList =
            "Command list: \n" +
                    "1 - Set cipher\n" +
                    "2 - Generate new key\n" +
                    "3 - Enter key\n" +
                    "4 - Enter message\n" +
                    "5 - Encrypt\n" +
                    "6 - Decrypt\n" +
                    "info\n" +
                    "list\n" +
                    "exit\n";


    public static void main(String[] args) throws Exception {
        boolean isFinished = false;
        printer("first");
        printer("list");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!isFinished) {
                System.out.print(">");
                String command = reader.readLine();
                switch (command) {
                    case "1":
                        printer(">>");
                        //set encryption type, cipher.AES by default
                        try {
                            cipher = CipherFactory.getCipherType(reader.readLine());
                        } catch (CipherDoesNotExist e) {
                            System.out.println("Entered cipher doesn't exist");
                        }
                        printer("info");
                        break;
                    case "2":
                        //generate new key
                        key = cipher.getRandomKey();
                        printer("info");
                        break;
                    case "3":
                        printer(">>");
                        key = reader.readLine();
                        printer("info");
                        break;
                    case "4":
                        //enter message
                        printer(">>");
                        message = reader.readLine();
                        printer("info");
                        break;
                    case "5":
                        //encrypt
                        message = cipher.encryptMessage(message, key);
                        printer("info");
                        break;
                    case "6":
                        //decrypt
                        message = cipher.decryptMessage(message, key);
                        printer("info");
                        break;
                    case "info":
                        printer("info");
                        break;
                    default:
                        printer("list");
                        break;
                    case "exit":
                        printer("exit");
                        return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printer(String command) {
        switch (command) {
            case ">>":
                System.out.print(">>");
                break;
            case "first":
                System.out.println("Possible ciphers - cipher.AES, cipher.Blowfish, cipher.EVC");
                break;
            case "info":
                System.out.printf("Cipher - %s\nKey - %s\nmessage - %s\n", cipher.getCipherType(), key, message);
                break;
            case "list":
                System.out.println(commandList);
                break;
            case "exit":
                System.out.println("Shutting down...");
                break;
        }
    }
}

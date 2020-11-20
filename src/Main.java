import java.io.*;

public class Main {
    private static String key = " ";
    private static String message = " ";
    private static MessageEncryption cipher = CipherFactory.getCipherType("AES");

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

    public static void main(String[] args) {

        boolean isFinished = false;
        printer("first");
        printer("list");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!isFinished) {
                try {
                    String command = reader.readLine();
                    switch (command) {
                        case "1":
                            //set encryption type, AES by default
                            cipher = CipherFactory.getCipherType(reader.readLine());
                            printer("info");
                            break;
                        case "2":
                            //generate new key
                            key = cipher.getRandomKey();
                            printer("info");
                            break;
                        case "3":
                            key = reader.readLine();
                            printer("info");
                            break;
                        case "4":
                            //enter message
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
                            return;
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printer(String command) {
        switch (command) {
            case "first":
                System.out.println("Possible ciphers - AES, Blowfish, EVC");
                break;
            case "info":
                System.out.printf("Cipher - %s\nKey - %s\nmessage - %s\n", cipher.getCipherType(), key, message);
                break;
            case "list":
                System.out.println(commandList);
                break;
        }
    }
}

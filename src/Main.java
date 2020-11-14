import javax.crypto.Cipher;
import java.io.*;
import java.util.Base64;

public class Main {
    private static String secretKey = null;
    private static String message = null;
    private static MessageEncryption cipher = null;

    public static void main(String[] args) throws Exception {

        boolean isFinished = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!isFinished) {
            try {
                String command = reader.readLine();
                switch (command) {
                    case "1":
                        //set encryption type, AES by default

                        cipher = new CipherFactory().getCipherMethod(reader.readLine());
                        break;
                    case "2":
                        //enter key
                        secretKey = reader.readLine();
                        System.out.println(secretKey);
                        String key = Base64.getEncoder().encodeToString(SecretKeyCreator.setKey(secretKey, "AES").getEncoded());
                        System.out.println(key);
                        break;
                    case "3":
                        //generate new key
                        secretKey = RandomKeyGenerator.getRandomKey(cipher.getCipherType());
                        System.out.println(secretKey);
                        break;
                    case "4":
                        //enter message
                        message = reader.readLine();
                        System.out.println(message);
                        break;
                    case "5":
                        //encrypt
                        System.out.println(cipher.encryptMessage(message, secretKey));
                        break;
                    case "6":
                        //decrypt
                        System.out.println(cipher.decryptMessage(message, secretKey));
                        break;
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        reader.close();
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

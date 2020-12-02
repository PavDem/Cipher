import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class CipherFactory {

    public static MessageEncryption getCipherType(String type) {
        try {
            switch (type.toLowerCase().trim()) {
                case "aes":
                    return new NativeJavaCipher("AES/ECB/PKCS5Padding", "AES");
                case "blowfish":
                    return new NativeJavaCipher("Blowfish", "Blowfish");
                case "evc":
                    return new EVC();
                default:
                    return new NativeJavaCipher("AES/ECB/PKCS5Padding", "AES"); //aes by default
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
            throw new RuntimeException();
            //should never occur
        }
    }
}

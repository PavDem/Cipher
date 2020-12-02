package cipher;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Blowfish extends NativeJavaCipher implements MessageEncryption {
    private static final String instance = "Blowfish";
    private static final String algorithm = "Blowfish";

    private Blowfish(String instance, String algorithm) throws NoSuchAlgorithmException, NoSuchPaddingException {
        super(instance, algorithm);
    }

    public static Blowfish create() {
        try {
            return new Blowfish(instance, algorithm);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
            throw new RuntimeException();
            //hardcoded, should never occur
        }
    }
}
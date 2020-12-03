package cipher;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class AES extends NativeJavaCipher implements MessageEncryption {
    private static final String instance = "AES/ECB/PKCS5Padding";
    private static final String algorithm = "AES";

    private AES(String instance, String algorithm) throws NoSuchAlgorithmException, NoSuchPaddingException {
        super(instance, algorithm);
    }

    public static AES create() {
        try {
            return new AES(instance, algorithm);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
            throw new RuntimeException();
            //hardcoded, should never occur
        }
    }
}

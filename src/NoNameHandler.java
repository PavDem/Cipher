import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class NoNameHandler {
    public SecretKey stringToSecretKey(String key) {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        return secretKey;
    }

    public String byteToString(byte[] bytes) {
        return null;
    }

    public byte[] stringToByte(String str) {
        return null;
    }
}

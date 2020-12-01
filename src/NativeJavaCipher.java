import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.stream.Stream;

public abstract class NativeJavaCipher  {
    private final String charsetName;
    private final String algorithm;
    private final Cipher cipher;

    public NativeJavaCipher(String charsetName, String instance, String algorithm)
            throws NoSuchAlgorithmException, NoSuchPaddingException {
        this.charsetName = charsetName;
        this.algorithm = algorithm;
        cipher = Cipher.getInstance(instance);
    }

    private SecretKey stringToSecretKey(String key) {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, algorithm);
        return secretKey;
    }

    public String encryptMessage(String message, String key) {
            cipher.init(1, stringToSecretKey(key));
            return cipher.doFinal(message);
    }

    public String decryptMessage(String message, String key) {
        cipher.init(2, stringToSecretKey(key));
        return cipher.doFinal(message);
    }
}

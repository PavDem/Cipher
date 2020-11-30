import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public abstract class AbstractNativeJavaCipher {
    private final String charsetName;
    private final String algorithm;
    private final Cipher cipher;

    public AbstractNativeJavaCipher(String charsetName, String instance, String algorithm)
            throws NoSuchAlgorithmException, NoSuchPaddingException {
        this.charsetName = charsetName;
        this.algorithm = algorithm;
        cipher = Cipher.getInstance(instance);
    }

    public String encrypt(String message, String key) throws InvalidKeyException {
        cipher.init(1, stringToSecretKey(key));
        return cipher.doFinal(message);
    }

    public String decrypt(String message, String key) throws InvalidKeyException {
        cipher.init(2, stringToSecretKey(key));
        return cipher.doFinal(message);
    }

    //перекводим байты в сикретКей
    private SecretKey stringToSecretKey(String key) {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, algorithm);
        return secretKey;
    }
}

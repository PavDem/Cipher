import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.stream.Stream;

public class NativeJavaCipher {
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

    private String byteToString(byte[] message) {
        return Base64.getEncoder().encodeToString(message);
    }

    private byte[] stringToByte(String message) {
        return Base64.getDecoder().decode(message);
    }

    public String encrypt(String message, String secretKey)
            throws  InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(1, stringToSecretKey(secretKey));
        byte[] bytes = stringToByte(message);
        bytes = cipher.doFinal(bytes);
        return byteToString(bytes);
    }

    public String decrypt(String message, String secretKey)
            throws  InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(2, stringToSecretKey(secretKey));
        byte[] bytes = stringToByte(message);
        bytes = cipher.doFinal(bytes);
        return byteToString(bytes);
    }
}

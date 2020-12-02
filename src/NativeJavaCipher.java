import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.stream.Stream;

public class NativeJavaCipher implements MessageEncryption {
    private final String algorithm;
    private final Cipher cipher;

    public NativeJavaCipher(String instance, String algorithm)
            throws NoSuchAlgorithmException, NoSuchPaddingException {
        this.algorithm = algorithm;
        cipher = Cipher.getInstance(instance);
    }



    private SecretKey stringToSecretKey(String key) {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, algorithm);
        return secretKey;
    }


    @Override
    public String encryptMessage(String message, String secretKey)
            throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(1, stringToSecretKey(secretKey));
        return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes(StandardCharsets.UTF_8)));
    }

    @Override
    public String decryptMessage(String message, String secretKey)
            throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(2, stringToSecretKey(secretKey));
        return new String(cipher.doFinal(Base64.getDecoder().decode(message.getBytes(StandardCharsets.UTF_8))));
    }

    @Override
    public String getCipherType() {
        return algorithm;
    }

    @Override
    public String getRandomKey() {
        return RandomKeyGenerator.getRandomKey(algorithm);
    }
}

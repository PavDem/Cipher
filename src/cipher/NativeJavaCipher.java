package cipher;

import cipher.MessageEncryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public abstract class NativeJavaCipher implements MessageEncryption {
    private final String algorithm;
    private final Cipher cipher;
    private static ExceptionHandler exceptionHandler = new ExceptionHandler();

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
    public String encryptMessage(String message, String secretKey) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, stringToSecretKey(secretKey));
            byte[] encrypted = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IllegalArgumentException e) {
            return exceptionHandler.nativeJavaCipherHandler(e, message);
        }
    }

    @Override
    public String decryptMessage(String message, String secretKey) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, stringToSecretKey(secretKey));
            byte[] decoded = Base64.getDecoder().decode(message.getBytes(StandardCharsets.UTF_8));
            byte[] decrypted = cipher.doFinal(decoded);
            return new String(decrypted);
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IllegalArgumentException e) {
            return exceptionHandler.nativeJavaCipherHandler(e, message);
        }

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

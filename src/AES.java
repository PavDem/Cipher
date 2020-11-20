import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AES implements MessageEncryption {

    @Override
    public String encryptMessage(String message, String key) {

        try {
            byte[] decodedKey = Base64.getDecoder().decode(key);
            SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            message = Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return message;
    }

    @Override
    public String decryptMessage(String message, String key) {
        try {
            byte[] decodedKey = Base64.getDecoder().decode(key);
            SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            message = new String(cipher.doFinal(Base64.getDecoder().decode(message.getBytes("UTF-8"))));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return message;
    }

    @Override
    public String getCipherType() {
        return "AES";
    }

    @Override
    public String getRandomKey() {
        return RandomKeyGenerator.getRandomKey("AES");
    }
}
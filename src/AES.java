import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class AES implements MessageEncryption {

    @Override
    public String encryptMessage(String message, String key) {
        SecretKey secretKey = SecretKeyCreator.setKey(key, "AES");
        try {

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    @Override
    public String decryptMessage(String message, String key) {
        SecretKey secretKey = SecretKeyCreator.setKey(key, "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(message.getBytes("UTF-8"))));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    @Override
    public String getCipherType() {
        return "AES";
    }
}
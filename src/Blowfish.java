import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Blowfish implements MessageEncryption {


    @Override
    public String encryptMessage(String message, String key) {
        try {
            byte[] decodedKey = Base64.getDecoder().decode(key);
            SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
        } catch (GeneralSecurityException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return message;
        }
    }

    @Override
    public String decryptMessage(String message, String key) {
        return RandomKeyGenerator.getRandomKey("Blowfish");
    }

    @Override
    public String getCipherType() {
        return "Blowfish";
    }

    @Override
    public String getRandomKey() {
        return RandomKeyGenerator.getRandomKey("Blowfish");
    }
}

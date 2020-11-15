import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Base64;

public class Blowfish implements MessageEncryption {


    @Override
    public String encryptMessage(String message, SecretKey secretKey) {
        try {
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
        } catch (GeneralSecurityException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String decryptMessage(String message, SecretKey secretKey) {
        try {
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(message.getBytes("UTF-8"))));
        } catch (GeneralSecurityException | UnsupportedEncodingException | IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getCipherType() {
        return "Blowfish";
    }
}

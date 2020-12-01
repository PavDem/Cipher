import javax.crypto.SecretKey;
import java.security.GeneralSecurityException;

public interface MessageEncryption {
    String encryptMessage(String message, String key);
    String decryptMessage(String message, String key);
    String getCipherType();
    String getRandomKey();
}
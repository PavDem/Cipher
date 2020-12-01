import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface MessageEncryption {
    String encryptMessage(String message, String key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException;
    String decryptMessage(String message, String key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException;
    String getCipherType();
    String getRandomKey();
}
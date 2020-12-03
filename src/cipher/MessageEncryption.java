package cipher;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface MessageEncryption {
    String encryptMessage(String message, String key);

    String decryptMessage(String message, String key);

    String getRandomKey();

    String getCipherType();

}
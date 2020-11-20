import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Blowfish extends AbstractJavaInnerCipher implements MessageEncryption {

    private Blowfish(String charsetName, String instance, String algorithm) {
        super(charsetName, instance, algorithm);
    }

    public Blowfish() {
        this("UTF-8", "Blowfish", "Blowfish");
    }

    @Override
    public String encryptMessage(String message, String key) {
        return encrypt(message, key);
    }

    @Override
    public String decryptMessage(String message, String key) {
        return decrypt(message, key);
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

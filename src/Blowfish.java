import javax.crypto.NoSuchPaddingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

public class Blowfish extends AbstractNativeJavaCipher implements MessageEncryption {

    private Blowfish(String charsetName, String instance, String algorithm)
            throws NoSuchAlgorithmException, NoSuchPaddingException {
        super(charsetName, instance, algorithm);
    }

    public Blowfish() {
        try {
            this("UTF-8", "Blowfish", "Blowfish");
        } catch (GeneralSecurityException e) {
            
        }
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

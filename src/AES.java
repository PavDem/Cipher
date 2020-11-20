import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AES extends AbstractJavaInnerCipher implements MessageEncryption {

    private AES(String charsetName, String instance, String algorithm) {
        super(charsetName, instance, algorithm);
    }

    public AES() {
        this("UTF-8", "AES/ECB/PKCS5Padding", "AES");
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
        return "AES";
    }

    @Override
    public String getRandomKey() {
        return RandomKeyGenerator.getRandomKey("AES");
    }

}
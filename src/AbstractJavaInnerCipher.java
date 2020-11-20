import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public abstract class AbstractJavaInnerCipher {
    private String charsetName;
    private String instance;
    private String algorithm;

    public AbstractJavaInnerCipher(String charsetName, String instance, String algorithm) {
        this.charsetName = charsetName;
        this.instance = instance;
        this.algorithm = algorithm;
    }

    public AbstractJavaInnerCipher() {
    }

    public String test(int mode, String message, String key) {
        try {
            byte[] decodedKey = Base64.getDecoder().decode(key);
            SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, algorithm);
            Cipher cipher = Cipher.getInstance(instance);
            cipher.init(mode, secretKey);
            message = Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes(charsetName)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return message;
    }

    public String encrypt(String message, String key) {

    }

}

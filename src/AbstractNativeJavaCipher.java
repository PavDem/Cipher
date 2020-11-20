import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public abstract class AbstractNativeJavaCipher {
    private String charsetName;
    private String instance;
    private String algorithm;

    public AbstractNativeJavaCipher(String charsetName, String instance, String algorithm) {
        this.charsetName = charsetName;
        this.instance = instance;
        this.algorithm = algorithm;
    }

    public AbstractNativeJavaCipher() {
    }

    private String magic(int mode, String message, String key) {
        String result = null;
        try {
            byte[] decodedKey = Base64.getDecoder().decode(key);
            SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, algorithm);
            Cipher cipher = Cipher.getInstance(instance);
            cipher.init(mode, secretKey);
            if (mode == 1) {
                result = Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes(charsetName)));
            } else {
                result = new String(cipher.doFinal(Base64.getDecoder().decode(message.getBytes(charsetName))));
            }
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
            e.printStackTrace();
        }
        return result;
    }

    public String encrypt(String message, String key) {
        return magic(1, message, key);
    }

    public String decrypt(String message, String key) {
        return magic(2, message, key);
    }

}

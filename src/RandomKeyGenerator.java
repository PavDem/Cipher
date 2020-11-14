import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class RandomKeyGenerator {


    public static String getRandomKey(String instance) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(instance);

            SecureRandom secureRandom = new SecureRandom();
            int keyBitSize = 256;
            keyGenerator.init(keyBitSize, secureRandom);

            SecretKey secretKey = keyGenerator.generateKey();
            return new String(Base64.getEncoder().encodeToString(secretKey.getEncoded()));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

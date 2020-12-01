import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AES extends NativeJavaCipher implements MessageEncryption {
    private static final String instance = "AES/ECB/PKCS5Padding";
    private static final String charsetName = "UTF-8";
    private static final String algorithm = "AES";

    private static NoNameHandler handler = new NoNameHandler();


    private AES(String charsetName, String instance, String algorithm)
            throws NoSuchAlgorithmException, NoSuchPaddingException {
        super(charsetName, instance, algorithm);
    }

    public AES() throws NoSuchAlgorithmException, NoSuchPaddingException {
        this(charsetName, instance, algorithm);
    }


    @Override
    public String encryptMessage(String message, String key)
            throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        return encrypt(message, key);
    }

    @Override
    public String decryptMessage(String message, String key)
            throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        return decrypt(message, key);
    }

    @Override
    public String getCipherType() {
        return algorithm;
    }

    @Override
    public String getRandomKey() {
        return RandomKeyGenerator.getRandomKey(algorithm);
    }

}
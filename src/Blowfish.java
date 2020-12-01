import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class Blowfish extends NativeJavaCipher {

    private Blowfish(String charsetName, String instance, String algorithm)
            throws NoSuchAlgorithmException, NoSuchPaddingException {
        super(charsetName, instance, algorithm);
    }

    public Blowfish() throws Exception{
        this("UTF-8", "Blowfish", "Blowfish");
    }

    //@Override
    public String encryptMessage(String message, String key) throws Exception{
        return encryptMessage(message, key);
    }

    //@Override
    public String decryptMessage(String message, String key) throws Exception{
        return decryptMessage(message, key);
    }

    //@Override
    public String getCipherType() {
        return "Blowfish";
    }

    //@Override
    public String getRandomKey() {
        return RandomKeyGenerator.getRandomKey("Blowfish");
    }
}

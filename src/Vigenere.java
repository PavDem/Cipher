import javax.crypto.SecretKey;

public class Vigenere implements MessageEncryption{
    public static final int ENCRYPT = 1;
    public static final int DECRYPT = 2;

    @Override
    public String encryptMessage(String message, SecretKey secretKey) {
        byte[] keyEncoded = secretKey.getEncoded();
        return null;
    }

    @Override
    public String decryptMessage(String message, SecretKey secretKey) {
        return null;
    }

    @Override
    public String getCipherType() {
        return null;
    }

    public void init(int mode, SecretKey secretKey) {

    }

    private void body () {
        
    }
}

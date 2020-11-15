import javax.crypto.SecretKey;

public interface MessageEncryption {

    String encryptMessage(String message, SecretKey secretKey);
    String decryptMessage(String message, SecretKey secretKey);
    String getCipherType();

}
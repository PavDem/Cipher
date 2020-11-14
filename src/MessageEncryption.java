public interface MessageEncryption {

    String encryptMessage(String message, String secretKey);
    String decryptMessage(String message, String secretKey);
    String getCipherType();

}
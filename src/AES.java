public class AES extends NativeJavaCipher implements MessageEncryption {

    private AES(String charsetName, String instance, String algorithm) {
        super(charsetName, instance, algorithm);
    }

    public AES() {
        this("UTF-8", "AES/ECB/PKCS5Padding", "AES");
    }

    @Override
    public String encryptMessage(String message, String key) {
        return encryptMessage(message, key);
    }

    @Override
    public String decryptMessage(String message, String key) {
        return decryptMessage(message, key);
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
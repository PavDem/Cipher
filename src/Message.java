public class Message {
    private String key;
    private String message;
    private MessageEncryption cipher;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageEncryption getCipher() {
        return cipher;
    }

    public void setCipher(MessageEncryption cipher) {
        this.cipher = cipher;
    }
}

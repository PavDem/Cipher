public class CipherFactory {

    public static MessageEncryption getCipherType(String type) {
        switch (type.toLowerCase().trim()) {
            case "aes":
                return new AES();
            case "blowfish":
                return new Blowfish();
            case "vigenere":
                return new Vigenere();
            default:
                return new AES(); //aes by default
        }
    }
}

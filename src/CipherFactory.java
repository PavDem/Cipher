public class CipherFactory {

    public static MessageEncryption getCipherMethod(String type) {
        switch (type.toLowerCase().trim()) {
            case "aes":
                return new AES();
            case "blowfish":
                return new Blowfish();
            case "ocm":
                return new Vigenere();
            default:
                return new AES(); //aes by default
        }
    }
}

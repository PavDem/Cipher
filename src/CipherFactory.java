public class CipherFactory {

    public MessageEncryption getCipherMethod(String type) {
        switch (type.toLowerCase().trim()) {
            case "aes":
                return new AES();
            case "blowfish":
                return new Blowfish();
        }

        return null;
    }
}

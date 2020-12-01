public class CipherFactory {

    public static MessageEncryption getCipherType(String type) {
        try {
            switch (type.toLowerCase().trim()) {
                case "aes":
                    return new AES();
                case "blowfish":
                    //return new Blowfish();
                    return null;
                case "evc":
                    return new EVC();
                default:
                    return new AES(); //aes by default
            }
        } catch (Exception e) {
            return null;
        }
    }
}

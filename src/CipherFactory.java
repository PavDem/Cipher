import cipher.*;

public class CipherFactory {

    public static MessageEncryption getCipherType(String type) {
        switch (type.toLowerCase().trim()) {
            case "aes":
                return AES.create();
            case "blowfish":
                return Blowfish.create();
            case "evc":
                return new EVC();
            default:
                throw new CipherDoesNotExist();
                //default sipher
        }
    }
}
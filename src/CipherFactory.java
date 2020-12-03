import cipher.*;

import java.util.Optional;

public class CipherFactory {

    public Optional<MessageEncryption> getCipherType(String type) {
        switch (type.toLowerCase().trim()) {
            case "aes":
                return Optional.of(AES.create());
            case "blowfish":
                return Optional.of(Blowfish.create());
            case "evc":
                return Optional.of(new EVC());
            default:
                return Optional.empty();
        }
    }
}
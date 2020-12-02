package cipher;

import cipher.MessageEncryption;


//cipher.EVC - Extended vigenere cipher
public class EVC implements MessageEncryption {

    //Extended self made vigenere cipher with all ascii symbols

    @Override
    public String encryptMessage(String message, String key) {
        if (key == null || message == null)
            return message;

        String cipherText = "";
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int caesar = key.charAt(i % key.length()) - 32;
            int sum = c - 32 + caesar;
            cipherText += (char) (sum % 95 + 32);
        }
        return cipherText;
    }

    @Override
    public String decryptMessage(String message, String key) {
        if (key == null || message == null)
            return message;

        String encoded = "";
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int caesar = key.charAt(i % key.length()) - 32;
            int sum = c - 32 + (95 - caesar);
            encoded += (char) (sum % 95 + 32);
        }
        return encoded;
    }

    @Override
    public String getCipherType() {
        return "EVC";
    }

    @Override
    public String getRandomKey() {
        return RandomKeyGenerator.getRandomKey("AES");
    }
}

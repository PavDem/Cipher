import javax.crypto.SecretKey;
import java.util.Base64;

class TestCipher {
    private static String key = "BANANAS";
    private static String message = "MESSAGE IT IS YES WE KNOW MESSAGE IT IS";

    // This function generates the key in
// a cyclic manner until it's length isi'nt 
// equal to the length of original text
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append(key);

        for (int i = 0; ; i++) {
            if (i == key.length())
                i = 0;
            if (sb.length() == message.length())
                break;
            sb.append(key.charAt(i));
        }

        String enhancedKey = sb.toString();
        sb.delete(0, sb.length());

        for (int i = 0; i < message.length(); i++) {
            int x = (message.charAt(i) + enhancedKey.charAt(i)) % 26;
            char z = (char) x;
            z += 'A';
            sb.append(z);
        }

        message = sb.toString();
        System.out.println(message);

        System.out.println("\n");

        for (int i = 0; i < message.length(); i++) {
            int x = (message.charAt(i) - enhancedKey.charAt(i) + 26) % 26;
            char z = (char) x;
            z += 'A';
            System.out.print(z);
        }
    }

}

// This code has been contributed by 29AjayKumar 
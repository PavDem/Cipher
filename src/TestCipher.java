import javax.crypto.SecretKey;
import java.util.Base64;

class TestCipher {
    private static String key = "BANANAS";
    private static String message = "MESSAGE IT IS YES WE KNOW MESSAGE IT IS";

    // This function generates the key in
// a cyclic manner until it's length isi'nt 
// equal to the length of original text
    public static void main(String[] args) {
        //test1();
        //test2();
        test4();
    }

    public static void test4() {
        String key = RandomKeyGenerator.getRandomKey("AES");
        String plaintext = "Message it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it isMessage it is";
        String cipherText = "";
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            int caesar = key.charAt(i % key.length()) - 32;
            int sum = c - 32 + caesar;
            cipherText += (char) (sum % 95 + 32);
        }

        String encoded = "";
        System.out.println(cipherText);

        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            int caesar = key.charAt(i % key.length()) - 32;
            int sum = c - 32 + (95 - caesar);
            encoded += (char) (sum % 95 + 32);
        }
        System.out.println(encoded);
    }

    public static void test1() {
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

    public static void test2() {
        int a, b, c, d, e;
        a = 'a';
        b = 'b';
        c = 'c';
        d = 'd';
        e = 'e';
        System.out.printf("%s, %s, %s, %s, %s", a, b, c, d, e);
    }

}

// This code has been contributed by 29AjayKumar 
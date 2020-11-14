
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

public class Test {
    public static void main(String[] args) throws Exception {

        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        byte[] keyBytes = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        IvParameterSpec ivspec = new IvParameterSpec(keyBytes);


        String algorithm = "RawBytes";
        SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);

        cipher.init(Cipher.ENCRYPT_MODE, key, ivspec);

        byte[] plainText = "My name is Pavel".getBytes("UTF-8");
        byte[] cipherText = cipher.doFinal(plainText);
        cipher.init(Cipher.DECRYPT_MODE, key, ivspec);
        byte[] encrypted = cipher.doFinal(cipherText);
        for (byte b : cipherText) {
            System.out.print(b);
        }
        for (byte b : encrypted) {
            System.out.print(b);
        }
    }
}

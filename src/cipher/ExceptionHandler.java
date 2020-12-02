package cipher;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionHandler {
    public String nativeJavaCipherHandler(Exception e, String message) {
        e.printStackTrace();
        Map<Class, Runnable> doByClass = new HashMap<>();
        doByClass.put(IllegalArgumentException.class, () ->
                System.out.println("Key or message have incorrect format or missing"));
        doByClass.put(InvalidKeyException.class, () -> System.out.println("Invalid key format"));
        doByClass.put(IllegalBlockSizeException.class, () -> System.out.println("Attempt to decrypt not encrypted text"));
        doByClass.put(BadPaddingException.class, () -> System.out.println("Incorrect key"));
        doByClass.get(e.getClass()).run();
        return message;

    }


}


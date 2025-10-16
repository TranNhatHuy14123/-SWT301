package huytran.example;

import java.util.logging.Logger;

public class OvercatchingExceptionExample {
    private static final Logger LOGGER = Logger.getLogger(OvercatchingExceptionExample.class.getName());

    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i * 10;
            }
            LOGGER.log(java.util.logging.Level.INFO, "Accessing element: {0}", arr[2]);
        } catch (ArrayIndexOutOfBoundsException _) {
            LOGGER.warning("Attempted to access array out of bounds!");
        }
    }
}

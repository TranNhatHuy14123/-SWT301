package huytran.example;

import java.util.logging.Logger;

public class CatchGenericExceptionExample {
    private static final Logger LOGGER = Logger.getLogger(CatchGenericExceptionExample.class.getName());

    public static void main(String[] args) {
        try {
            String s = Math.random() > 0.5 ? "Hello" : null;
            if (s != null) {
                LOGGER.info(String.format("Length: %d", s.length()));
            } else {
                LOGGER.warning("Variable 's' is null, skipping length calculation.");
            }

        } catch (NullPointerException _) {
            LOGGER.severe("NullPointerException occurred while accessing 's'.");
        }
    }
}

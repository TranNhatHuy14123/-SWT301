package huytran.example;

import java.util.logging.Logger;

public class NullPointerExample {
    private static final Logger LOGGER = Logger.getLogger(NullPointerExample.class.getName());

    public static void main(String[] args) {
        String text = getUserInput();

        if (text != null && !text.isEmpty()) {
            LOGGER.info("Text is not empty");
        } else if (text == null) {
            LOGGER.warning("Text is null, skipping check.");
        } else {
            LOGGER.info("Text is empty");
        }
    }
    private static String getUserInput() {
        return Math.random() > 0.5 ? "Hello" : null;
    }
}

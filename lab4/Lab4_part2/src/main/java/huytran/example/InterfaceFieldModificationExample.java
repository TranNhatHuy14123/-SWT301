package huytran.example;

import java.util.logging.Logger;

public class InterfaceFieldModificationExample {
    private static final Logger LOGGER = Logger.getLogger(InterfaceFieldModificationExample.class.getName());

    public static void main(String[] args) {
        LOGGER.info(String.format("Max users allowed: %d", AppConstants.MAX_USERS));
    }
}

package huytran.example;

import java.util.logging.Logger;

public class HardcodedCredentialsExample {
    private static final Logger LOGGER = Logger.getLogger(HardcodedCredentialsExample.class.getName());

    public static void main(String[] args) {
        String username = System.getenv("APP_USERNAME");
        String password = System.getenv("APP_PASSWORD");

        if (username == null || password == null) {
            LOGGER.warning("Missing credentials in environment variables.");
            return;
        }

        if (authenticate(username, password)) {
            LOGGER.info("Access granted");
        } else {
            LOGGER.warning("Access denied");
        }
    }

    private static boolean authenticate(String user, String pass) {
        String validUser = "admin";
        String validPassword = "123456";
        return user.equals(validUser) && pass.equals(validPassword);
    }
}

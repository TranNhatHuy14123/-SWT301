package huytran.example;

import java.util.logging.Level;
import java.util.logging.Logger;

interface LoginHandler {
    boolean login(String username, String password);
}

class LoginHandlerImpl implements LoginHandler {
    private static final Logger logger = Logger.getLogger(LoginHandlerImpl.class.getName());

    @Override
    public boolean login(String username, String password) {
        boolean success = "admin".equals(username) && "123".equals(password);
        logger.log(Level.INFO, "Login attempt for user {0}: {1}", new Object[]{username, success ? "SUCCESS" : "FAIL"});
        return success;
    }
}

public class InterfaceNamingInconsistencyExample {
    private static final Logger logger = Logger.getLogger(InterfaceNamingInconsistencyExample.class.getName());

    public static void main(String[] args) {
        LoginHandler handler = new LoginHandlerImpl();
        boolean result = handler.login("admin", "123");
        logger.log(Level.INFO, "Login successful? {0}", result);
    }
}

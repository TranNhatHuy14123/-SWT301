package huytran.example;

import java.util.logging.Logger;

public class UnreachableCodeExample {
    private static final Logger logger = Logger.getLogger(UnreachableCodeExample.class.getName());

    public static int getNumber() {
        logger.info("getNumber() trả về 42");
        return 42;
    }

    public static void main(String[] args) {
        // Dùng logger thay vì System.out
        logger.info("Kết quả: " + getNumber());
    }
}

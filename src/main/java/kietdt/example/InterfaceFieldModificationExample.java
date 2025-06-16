package kietdt.example;

import java.util.logging.Logger;

public final class AppConstants {
    public static final int MAX_USERS = 100;

    // Ẩn constructor để ngăn tạo object
    private AppConstants() {
        throw new UnsupportedOperationException("Utility class");
    }
}

public class InterfaceFieldModificationExample {
    private static final Logger logger = Logger.getLogger(InterfaceFieldModificationExample.class.getName());

    public static void main(String[] args) {
        logger.info("Max users allowed: " + AppConstants.MAX_USERS);
    }
}

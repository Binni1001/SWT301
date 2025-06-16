package kietdt.example;

import java.util.logging.Logger;

public class HardcodedCredentialsExample {
    private static final Logger logger = Logger.getLogger(HardcodedCredentialsExample.class.getName());

    public static void main(String[] args) {
        String username = System.getenv("APP_USERNAME");
        String password = System.getenv("APP_PASSWORD");

        if (authenticate(username, password)) {
            logger.info("Access granted");
        } else {
            logger.warning("Access denied");
        }
    }

    private static boolean authenticate(String user, String pass) {
        String expectedUser = System.getenv("APP_USERNAME");
        String expectedPass = System.getenv("APP_PASSWORD");
        return user != null && pass != null && user.equals(expectedUser) && pass.equals(expectedPass);
    }
}

package kietdt.example;

import java.util.logging.Logger;

public class UnreachableCodeExample {
    private static final Logger logger = Logger.getLogger(UnreachableCodeExample.class.getName());

    public static int getNumber() {
        logger.info("Returning 42 from getNumber()");
        return 42;
    }

    public static void main(String[] args) {
        logger.info("Result: " + getNumber());
    }
}

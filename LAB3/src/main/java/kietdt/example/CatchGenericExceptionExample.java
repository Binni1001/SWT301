package kietdt.example;

import java.util.logging.Logger;

public class CatchGenericExceptionExample {

    private static final Logger LOGGER = Logger.getLogger(CatchGenericExceptionExample.class.getName());

    public static void main(String[] args) {
        try {
            String s = "hihi";
            LOGGER.info(() -> "Length: " + s.length());
        } catch (Exception e) {
            LOGGER.severe("Something occurred: " + e.getMessage());
        }
    }
}

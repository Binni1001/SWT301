package kietdt.example;

import java.util.logging.Logger;

public class OvercatchingExceptionExample {

    private static final Logger logger = Logger.getLogger(OvercatchingExceptionExample.class.getName());

    public static void main(String[] args) {
        int[] arr = new int[5];

        try {
            String message = String.format("Element at index : %d", arr[10]);
            logger.info(message);
        } catch (RuntimeException e) {
            String warning = "Index 10 is out of bounds array length";
            logger.warning(warning);
        }
    }
}

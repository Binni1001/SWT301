package kietdt.example;

import java.io.*;
import java.util.logging.Logger;

public class PathTraversalExample {
    private static final Logger logger = Logger.getLogger(PathTraversalExample.class.getName());

    private static final String BASE_DIRECTORY = "data/";

    public static void main(String[] args) {
        String userInput = "example.txt"; // giả lập đầu vào hợp lệ

        File file = new File(BASE_DIRECTORY, userInput);
        try {
            if (!file.getCanonicalPath().startsWith(new File(BASE_DIRECTORY).getCanonicalPath())) {
                logger.warning("Unauthorized access attempt detected.");
                return;
            }

            if (file.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    logger.info("Reading file: " + file.getCanonicalPath());
                }
            } else {
                logger.warning("File does not exist.");
            }
        } catch (IOException e) {
            logger.severe("Error reading file: " + e.getMessage());
        }
    }
}

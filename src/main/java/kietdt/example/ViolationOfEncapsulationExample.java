package kietdt.example;

import java.util.logging.Logger;

class User {
    private static final Logger logger = Logger.getLogger(User.class.getName());

    private String name;
    private int age;

    public void display() {
        String message = String.format("Name: %s, Age: %d", name, age);
        logger.info(message);
    }
}

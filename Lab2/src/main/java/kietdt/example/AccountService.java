package kietdt.example;

public class AccountService {
    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public boolean registerAccount(String username, String password, String email) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (password == null || password.length() <= 6) {
            throw new IllegalArgumentException("Password must be longer than 6 characters");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return true;
    }

    public boolean isStrongPassword(String password) {
        if (password == null || password.length() <= 6) {
            return false;
        }
        return password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[!@#$%^&*].*");
    }

    public void resetPassword(String oldPassword, String newPassword) {
        if (oldPassword == null || newPassword == null) {
            throw new IllegalArgumentException("Passwords cannot be null");
        }
        if (!isStrongPassword(newPassword)) {
            throw new IllegalArgumentException("New password must be strong");
        }
    }
}
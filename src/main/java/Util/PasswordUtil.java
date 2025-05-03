package Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    private static final String HASH_ALGORITHM = "SHA-256"; // You can use bcrypt or PBKDF2 for better security

    // Hash the password
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] hashBytes = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Check if the password matches the hashed password
    public static boolean checkPassword(String inputPassword, String storedHashedPassword) {
        return hashPassword(inputPassword).equals(storedHashedPassword);
    }
}

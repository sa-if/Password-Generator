import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Arrays;

public class PasswordGenerator {

    // Generate a random password with the specified options
    public static String generatePassword(int length, boolean includeSpecialChars, boolean includeDigits, 
                                          int numSpecialChars, int numDigits) {
        // Generate a password with the specified length
        String passwordChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=[]{}|;':\"<>,.?/~`";
        SecureRandom random = new SecureRandom();
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            password[i] = passwordChars.charAt(random.nextInt(passwordChars.length()));
        }
        String result = new String(password);

        // Make sure the password contains the required number of special characters and digits
        if (includeSpecialChars) {
            int specialChars = 0;
            for (char c : password) {
                if (!Character.isLetterOrDigit(c)) {
                    specialChars++;
                }
            }
            while (specialChars < numSpecialChars) {
                result = new String(password);
                specialChars = 0;
                for (char c : password) {
                    if (!Character.isLetterOrDigit(c)) {
                        specialChars++;
                    }
                }
            }
        }
        if (includeDigits)
import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Arrays;

public class PasswordGenerator {

    // Generate a random password with the specified options
    public static String generatePassword(int length, boolean includeSpecialChars, boolean includeDigits, 
                                          int numSpecialChars, int numDigits) {
        // Generate a password with the specified length
        String passwordChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=[]{}|;':\"<>,.?/~`";
        SecureRandom random = new SecureRandom();
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            password[i] = passwordChars.charAt(random.nextInt(passwordChars.length()));
        }
        String result = new String(password);

                // Make sure the password contains the required number of special characters and digits
        if (includeSpecialChars) {
            int specialChars = 0;
            for (char c : password) {
                if (!Character.isLetterOrDigit(c)) {
                    specialChars++;
                }
            }
            while (specialChars < numSpecialChars) {
                result = new String(password);
                specialChars = 0;
                for (char c : password) {
                    if (!Character.isLetterOrDigit(c)) {
                        specialChars++;
                    }
                }
            }
        }
        if (includeDigits) {
            int digits = 0;
            for (char c : password) {
                if (Character.isDigit(c)) {
                    digits++;
                }
            }
            while (digits < numDigits) {
                result = new String(password);
                digits = 0;
                for (char c : password) {
                    if (Character.isDigit(c)) {
                        digits++;
                    }
                }
            }
        }
    }
}


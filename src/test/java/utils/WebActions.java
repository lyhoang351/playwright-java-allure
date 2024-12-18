package utils;

import com.microsoft.playwright.Locator;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class WebActions {

    public static boolean waitUntilElementDisplayed(Locator locator, int timeoutSec) {
        boolean elementVisible = locator.isVisible();
        int timer = 0;
        while (!elementVisible && timer < timeoutSec) {
            try {
                Thread.sleep(1000);
                elementVisible = locator.isVisible();
                timer++;

            } catch (Exception e) {
                System.out.println(locator + " was not visible.");
            }
        }
        return elementVisible;
    }

    //base64 encoding: This is used to encrypt the password and save the encrypted value in config.properties file
    public static void encrypt() {
        try {
            byte[] encodedBytes = Base64.getEncoder().encode("yourPassword".getBytes(StandardCharsets.UTF_8));
            String encodedValue = new String(encodedBytes);
        } catch (Exception e) {
            System.out.println("Password was not Encrypted.");
        }
    }

    //base64 decoding: This is used to decrypt the password from the encrypted value in config.properties file while passing to app
    public static String decrypt(String password) {
        String decodedString = "";
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(password);
            decodedString = new String(decodedBytes);
        } catch (Exception e) {
            System.out.println("Password was nor Decrypted.");
        }
        return decodedString;
    }
}
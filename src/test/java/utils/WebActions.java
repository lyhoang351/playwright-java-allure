package utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.util.Base64;
import java.util.Calendar;
import java.util.Properties;

public class WebActions {
    private final Page page;

    public WebActions(Page page) {
        this.page = page;
    }

    public static String getProperty(String key) {
        ConfigReader configReader = new ConfigReader();
        Properties properties = configReader.initProp();    // Reading from config properties file
        return properties.getProperty(key);
    }

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
            byte[] encodedBytes = Base64.getEncoder().encode("yourPassword".getBytes("UTF-8"));
            String encodedValue = new String(encodedBytes);
        } catch (Exception e) {
            System.out.println("Password was not Encrypted.");
        }
    }

    //base64 decoding: This is used to decrypt the password from the encrypted value in config.properties file while passing to app
    public static String decrypt(String password) {
        String encodedBytes = password;
        String decodedString = "";
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
            decodedString = new String(decodedBytes);
        } catch (Exception e) {
            System.out.println("Password was nor Decrypted.");
        }
        return decodedString;
    }

//    public static String getRowColValue(String filePath, String sheetName, int rowNum, int colNum) {
//        String fileName = System.getProperty("user.dir") + "\\src\\main\\java\\utils\\functional\\" + filePath + ".xlsx";
//        Workbook workbook = null;
//        try {
//            workbook = WorkbookFactory.create(new File(fileName));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Sheet sheet = workbook.getSheet(sheetName);
//        return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//    }

    public byte[] takeScreenShots()
    {
	    byte[] array;
        long millisStart = Calendar.getInstance().getTimeInMillis();
        array = this.page.screenshot(new Page.ScreenshotOptions().setFullPage(false).setPath(Paths.get("target/ScreenShots/" + millisStart + ".png")));
        return array;
    }
}
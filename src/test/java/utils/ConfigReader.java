package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public Properties initProp() {
        String env = System.getProperty("env", "dev"); // default to "dev" if not set
        this.properties = new Properties();
        
        try {
            // Load properties based on the environment
            String propertiesFile = "src/test/resources/config/" + env + ".properties";
            this.properties.load(new FileInputStream(propertiesFile));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load properties file for environment: " + env);
        }
        return this.properties;
    }

    // //This is used to raed from properties files and returns properties object
    // public Properties initProp() {
    //     properties = new Properties();
    //     try {
    //         FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config/config.properties");
    //         properties.load(fileInputStream);
    //     } catch (Exception e) {
    //         System.out.println("Unable to read Properties file.");
    //     }
    //     return properties;
    // }
}
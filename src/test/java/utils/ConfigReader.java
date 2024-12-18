package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private final static Properties properties = new Properties();
    static {
        String env = System.getProperty("env", "dev"); // default to "dev" if not set
        try {
            // Load properties based on the environment
            String propertiesFile = "src/test/resources/config/" + env + ".properties";
            properties.load(new FileInputStream(propertiesFile));
        } catch (Exception e) {
            throw new RuntimeException("Could not load properties file for environment: " + env);
        }
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
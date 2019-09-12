package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private static FileInputStream fileInputStream;
    private static Properties PROPERTIES;

    private ConfigProperties() {}
    static {
        try {
            fileInputStream = new FileInputStream("src/main/resources/config.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        System.setProperty("browser", PROPERTIES.getProperty("browser"));
    }

    public static String getTestProperty(String key){
        return PROPERTIES.getProperty(key);
    }
}

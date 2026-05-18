import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String getBaseUrl() {
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("config.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty("baseUrl");
    }
}
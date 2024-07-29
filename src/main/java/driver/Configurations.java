package driver;

import java.io.InputStream;
import java.util.Properties;

public class Configurations {
    static String BROWSER;

    static {
        Properties properties = new Properties();
        try (InputStream input = Configurations.class.getClassLoader().getResourceAsStream("calc.properties")) {
            properties.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        BROWSER = properties.getProperty("browser");
    }
}

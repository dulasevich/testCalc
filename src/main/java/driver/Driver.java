package driver;

import org.openqa.selenium.WebDriver;

public class Driver {
    protected static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver == null) {
            driver = DriverFactory.setBrowser("Edge");
        }
        return driver;
    }

    public static void tearDown() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

package driver;

import org.openqa.selenium.WebDriver;

import static driver.Configurations.BROWSER;

public class Driver {
    protected static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = DriverFactory.getDriver(BROWSER);
        }
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

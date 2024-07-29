package pages;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import waiter.Waiter;

public class BasePage {
    protected WebDriver driver;
    protected Waiter waiter;

    protected BasePage() {
        driver = Driver.getDriver();
        waiter = new Waiter(driver);
    }
}

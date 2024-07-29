package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CalcPage;
import driver.Driver;

public class BaseTest {
    protected WebDriver driver;
    protected CalcPage calcPage;
    private final static String URL = "https://web2.0calc.com/";

    @BeforeMethod
    void initializeDriver() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        calcPage = new CalcPage();
        calcPage.closeCookieAlert();
    }

    @AfterMethod
    void closeDriver() {
        Driver.tearDown();
    }
}

package waiter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    private WebDriver driver;

    public Waiter(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilAttributeValueIsNot(By selector, String inputValue) {
        new WebDriverWait(driver, Duration.ofMillis(2000))
                .until(attributeValueIsNot(selector, inputValue));
    }

    private static ExpectedCondition<Boolean> attributeValueIsNot(By selector, String inputValue) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                WebElement element = driver.findElement(selector);
                return !element.getAttribute("value").equals(inputValue);
            }
        };
    }
}

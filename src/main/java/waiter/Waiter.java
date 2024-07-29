package waiter;

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

    public void waitUntilAttributeValueIsNot(WebElement element, String inputValue) {
        new WebDriverWait(driver, Duration.ofMillis(1000))
                .until(attributeValueIsNot(element, inputValue));
    }

    private static ExpectedCondition<Boolean> attributeValueIsNot(WebElement element, String value) {
        return input -> !element.getAttribute("value").equals(value);
    }
}

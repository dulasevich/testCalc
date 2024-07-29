package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static constants.TestConstants.COS_EXPRESSION;

public class CalcPage extends BasePage {
    private static final By CLOSE_COOKIES_ALERT_BUTTON = By.cssSelector(".fc-choice-dialog-header button");
    private static final By CALC_INPUT_FIELD = By.cssSelector("#input");
    private static final By CALCULATE_BUTTON = By.cssSelector("#BtnCalc");
    private static final By RAD_CHECKBOX = By.id("trigorad");
    private static final By HISTORY_DROPDOWN = By.cssSelector(".history");
    private static final By CANCEL_BUTTON = By.cssSelector("#BtnClear");
    private static final By HISTORY_ELEMENTS = By.cssSelector("p[data-inp]");

    public CalcPage() {
        super();
    }

    public void closeCookiesAlert() {
        driver.findElement(CLOSE_COOKIES_ALERT_BUTTON).click();
    }

    public void enterCalcExpression(String inputData) {
        driver.findElement(CALC_INPUT_FIELD).sendKeys(inputData);
    }

    public void calculateResults(String inputValue) {
        driver.findElement(CALCULATE_BUTTON).click();
        waiter.waitUntilAttributeValueIsNot(CALC_INPUT_FIELD, inputValue);
    }

    public String getCalculationResult() {
        return driver.findElement(CALC_INPUT_FIELD).getAttribute("value");
    }

    public void selectRadCheckbox() {
        driver.findElement(RAD_CHECKBOX).click();
    }

    public void clickHistoryDropDown() {
        driver.findElement(HISTORY_DROPDOWN).click();
    }

    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public List<String> getHistoryOperations() {
        return driver.findElements(HISTORY_ELEMENTS).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void checkCalcExpressionType(String inputData) {
        if (inputData.equals(COS_EXPRESSION)) {
            selectRadCheckbox();
        }
    }

    public void scrollToHistory() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(HISTORY_DROPDOWN));
    }
}

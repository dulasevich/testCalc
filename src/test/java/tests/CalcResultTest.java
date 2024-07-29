package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import parameters.Params;

import java.util.List;

import static constants.TestConstants.*;

public class CalcResultTest extends BaseTest {

    @Test(dataProvider = "expressionsForParams", dataProviderClass = Params.class)
    public void calculationsTest(String inputDate, String result) {
        calcPage.enterCalcExpression(inputDate);
        calcPage.checkCalcExpressionType(inputDate);
        calcPage.calculateResults(inputDate);
        Assert.assertEquals(calcPage.getCalculationResult(), result);
    }

    @Test()
    public void historyTest() {
        calcPage.enterCalcExpression(REGULAR_EXPRESSION);
        calcPage.calculateResults(REGULAR_EXPRESSION);
        calcPage.clickCancelButton();
        calcPage.enterCalcExpression(SQRT_EXPRESSION);
        calcPage.calculateResults(SQRT_EXPRESSION);
        calcPage.clickCancelButton();
        calcPage.enterCalcExpression(COS_EXPRESSION);
        calcPage.selectRadCheckbox();
        calcPage.calculateResults(COS_EXPRESSION);

        calcPage.scrollToHistory();
        calcPage.clickHistoryDropDown();
        Assert.assertEquals(calcPage.getHistoryExpressions(), List.of(COS_EXPRESSION, SQRT_EXPRESSION, REGULAR_EXPRESSION));
    }
}

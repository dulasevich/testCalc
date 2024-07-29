package parameters;

import org.testng.annotations.DataProvider;

import static constants.TestConstants.*;

public class Params {

    @DataProvider
    public static Object[][] expressionsForParams() {
        return new Object[][]{
                {REGULAR_EXPRESSION, REGULAR_EXPRESSION_EXPECTED},
                {COS_EXPRESSION, COS_EXPRESSION_EXPECTED},
                {SQRT_EXPRESSION, SQRT_EXPRESSION_EXPECTED},
        };
    }
}

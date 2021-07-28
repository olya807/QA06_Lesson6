package tests.Login;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginStep;

public class NegativeLoginEmptyUserNameAndPasswordTest extends BaseTest {

    @Test(priority = 2)
    public void negativeLoginEmptyUserNameAndPasswordTest() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login("", "");

        Assert.assertEquals(
                new LoginPage(driver, false).getLoginRequiredLabel().getText(),
                "Email/Login is required.",
                "'Email/Login' required text is not correct."
        );
        Assert.assertEquals(
                new LoginPage(driver, false).getPasswordRequiredLabel().getText(),
                "Password is required.",
                "'Password' required text is not correct."
        );
    }
}

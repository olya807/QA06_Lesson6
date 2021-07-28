package tests.Login;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginStep;

public class NegativeLoginWrongPasswordTest extends BaseTest {

    @Test(priority = 2)
    public void negativeLoginWrongPasswordTest() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUserName(), "%1.2/*3!4^#5)");

        Assert.assertEquals(
                new LoginPage(driver, false).getErrorLabel().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Error text is not correct."
        );
    }
}

package tests.Login;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginStep;

public class NegativeLoginWrongUserNameAndPasswordTest extends BaseTest {

    @Test(priority = 2)
    public void negativeLoginWrongUserNameAndPasswordTest() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login("sadface", "cvbjfg");

        Assert.assertEquals(
                new LoginPage(driver, false).getErrorLabel().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Error text is not correct."
        );
    }
}

package tests.Login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginStep;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void negativeTest() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login("sadface", "cvbjfg");

        Assert.assertEquals(new LoginPage(driver, false).getErrorLabel().getText(),
                "Epic sadface: Username and password do not match any user in this service"
        );
    }
}

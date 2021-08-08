package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import steps.LoginSteps;

public class LoginTest extends BaseTest {

    @Test(description = "TestRail positive login test")
    public void positiveLoginTest() {

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials(properties.getUserName(), properties.getPassword());

        Assert.assertTrue(
                new DashboardPage(browserService, false).isPageOpen(),
                "'Dashboard' page is not opened."
        );
    }

    @Test
    public void negativeLoginTest() {

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithIncorrectCredentials("sadface", "cvbjfg");

        Assert.assertEquals(new LoginPage(browserService, false).getErrorLabel().getText(),
                "Epic sadface: Username and password do not match any user in this service"
        );
    }

    @Test(description = "Attachment on Fail test")
    public void positiveLoginAttachmentOnFailTest() {

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials(properties.getUserName(), properties.getPassword());

        Assert.assertTrue(
                false
        );
    }
}

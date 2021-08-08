package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import steps.LoginStep;

public class LoginTest extends BaseTest {

    @Test(description = "TestRail positive login test")
    public void positiveLoginTest() {

        LoginStep loginStep = new LoginStep(browserService);
        loginStep.loginWithCorrectCredentials(properties.getUserName(), properties.getPassword());

        Assert.assertTrue(
                new DashboardPage(browserService, false).isPageOpen(),
                "'Dashboard' page is not opened."
        );
    }

    @Test
    public void negativeLoginTest() {

        LoginStep loginStep = new LoginStep(browserService);
        loginStep.loginWithIncorrectCredentials("sadface", "cvbjfg");

        Assert.assertEquals(new LoginPage(browserService, false).getErrorLabel().getText(),
                "Epic sadface: Username and password do not match any user in this service"
        );
    }

    @Test(description = "Attachment on Fail test")
    public void positiveLoginAttachmentOnFailTest() {

        LoginStep loginStep = new LoginStep(browserService);
        loginStep.loginWithCorrectCredentials(properties.getUserName(), properties.getPassword());

        Assert.assertTrue(
                false
        );
    }
}

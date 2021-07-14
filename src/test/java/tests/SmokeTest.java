package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import steps.LoginStep;

public class SmokeTest extends BaseTest {

    @Test
    public void positiveLoginTest() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUserName(), properties.getPassword());

        ProductsPage productsPage = new ProductsPage(driver, false);
        Assert.assertEquals(productsPage.getTitleText(), "PRODUCTS", "'Products' page is not opened.");
    }

    @Test
    public void negativeTest() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login("sadface", "cvbjfg");

        Assert.assertEquals(new LoginPage(driver, false).getErrorLabel().getText(),
                "Epic sadface: Username and password do not match any user in this service"
        );
    }
}

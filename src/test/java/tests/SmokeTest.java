package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class SmokeTest extends BaseTest {

    @Test
    public void positiveLoginTest() {

        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver, false);
        Assert.assertEquals(productsPage.getTitleText(), "PRODUCTS", "'Products' page is not opened.");
    }

    @Test
    public void negativeTest() {

        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName("sadfasf");
        loginPage.setPassword("cvbjfg");
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getErrorLabel().getText(),
                "Epic sadface: Username and password do not match any user in this service"
        );
    }
}

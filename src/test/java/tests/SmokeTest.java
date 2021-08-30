package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import steps.CheckoutSteps;
import steps.LoginSteps;

import java.util.Arrays;
import java.util.List;

public class SmokeTest extends BaseTest {

    @Test
    public void positiveLoginTest() {

        ProductsPage productsPage =  new LoginSteps(driver)
                .loginWithCorrectData();

        Assert.assertEquals(
                productsPage.getTitleText(),
                "PRODUCTS",
                "'Products' page is not opened."
        );
    }

    @Test
    public void negativeLoginTest() {

        LoginPage loginPage = new LoginSteps(driver)
                .loginWithIncorrectData("sadface", "cvbjfg");

        Assert.assertEquals(
                loginPage.error_Label_By.getText(),
                "Epic sadface: Username and password do not match any user in this service"
        );
    }

    @Test
    public void addProductToCart() {

        ProductsPage productsPage = new LoginSteps(driver)
                .loginWithCorrectData()
                .addToCart("Sauce Labs Backpack");

        Assert.assertEquals(
                productsPage.getCartBadgeText(),
                "1",
                "Product wasn't added to cart"
        );
    }

    @Test
    public void removeProductFromCart() {

        List<String> productsAddList = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt"
        );
        List<String> productsRemoveList = Arrays.asList("Sauce Labs Backpack");

        ProductsPage productsPage = new LoginSteps(driver)
                .loginWithCorrectData()
                .addProducts(productsAddList)
                .removeProducts(productsRemoveList);

        Assert.assertEquals(
                productsPage.getCartBadgeText(),
                "2",
                "Product wasn't removed from cart"
        );
    }

    @Test
    public void addProductsAndGoToShoppingCart() {

        List<String> productsAddList = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light"
        );

        ShoppingCartPage shoppingCart = new LoginSteps(driver)
                .loginWithCorrectData()
                .addProductsAndGoToCart(productsAddList);

        Assert.assertEquals(
                shoppingCart.getTitleLabel().getText(),
                "YOUR CART",
                "Shopping cart page wasn't opened"
        );
        Assert.assertEquals(
                shoppingCart.getCartItemLabels().size(),
                2,
                "Number of products in shopping cart list is not correct"
        );
    }

    @Test
    public void removeShoppingCartProducts() {

        List<String> productsAddList = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt"
        );
        List<String> productsRemoveList = Arrays.asList("Sauce Labs Backpack");

        ShoppingCartPage shoppingCartPage = new LoginSteps(driver)
                .loginWithCorrectData()
                .addProductsAndGoToCart(productsAddList)
                .removeProducts(productsRemoveList);

        Assert.assertEquals(
                shoppingCartPage.getCartBadgeText(),
                "2",
                "Product wasn't removed from cart"
        );
    }

    @Test
    public void goToCheckoutShoppingCartProducts() {

        List<String> productsAddList = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt"
        );

        CheckoutPage checkoutPage = new LoginSteps(driver)
                .loginWithCorrectData()
                .addProducts(productsAddList)
                .clickShoppingCartLink()
                .clickCheckoutButton();

        Assert.assertEquals(
                new ProductsPage(driver, false).getCartBadgeText(),
                "3",
                "Product wasn't removed from cart"
        );
        Assert.assertTrue(
                checkoutPage.firstName_Input_By.isDisplayed(),
                "First Name is not displayed"
        );
        Assert.assertTrue(
                checkoutPage.lastName_Input_By.isDisplayed(),
                "Last Name is not displayed"
        );
        Assert.assertTrue(
                checkoutPage.postalCode_Input_By.isDisplayed(),
                "Postal Code is not displayed"
        );
    }

    @Test
    public void checkoutShoppingCartProducts() {

        List<String> productsAddList = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt"
        );

        new LoginSteps(driver)
                .loginWithCorrectData()
                .addProducts(productsAddList)
                .clickShoppingCartLink()
                .clickCheckoutButton();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutSteps(driver)
                .fillInCheckoutDataAndSend();

        Assert.assertEquals(
                checkoutOverviewPage.title_Label_By.getText(),
                "CHECKOUT: OVERVIEW",
                "'Checkout Overview' page is not displayed"
        );
        Assert.assertTrue(
                checkoutOverviewPage.finish_Button_By.isDisplayed(),
                "Finish button is not displayed"
        );
    }
}

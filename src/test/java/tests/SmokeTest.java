package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import steps.CheckoutSteps;
import steps.LoginSteps;
import steps.ProductsSteps;
import steps.ShoppingCartSteps;

import java.util.Arrays;
import java.util.List;

public class SmokeTest extends BaseTest {

    @Test
    public void positiveLoginTest() {

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(properties.getUserName(), properties.getPassword());

        ProductsPage productsPage = new ProductsPage(driver, false);
        Assert.assertEquals(productsPage.getTitleText(), "PRODUCTS", "'Products' page is not opened.");
    }

    @Test
    public void negativeLoginTest() {

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login("sadface", "cvbjfg");

        Assert.assertEquals(new LoginPage(driver, false).getErrorLabel().getText(),
                "Epic sadface: Username and password do not match any user in this service"
        );
    }

    @Test
    public void addProductToCart() {

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(properties.getUserName(), properties.getPassword());

        ProductsPage product = new ProductsPage(driver, true);
        product.addToCart("Sauce Labs Backpack");

        Assert.assertEquals(
                product.getCartBadgeText(),
                "1",
                "Product wasn't added to cart"
        );
    }

    @Test
    public void removeProductFromCart() {

        List<String> productsAddList = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt");
        List<String> productsRemoveList = Arrays.asList("Sauce Labs Backpack");

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(properties.getUserName(), properties.getPassword());

        ProductsSteps productsSteps = new ProductsSteps(driver);
        productsSteps.addProducts(productsAddList);

        productsSteps.removeProducts(productsRemoveList);

        Assert.assertEquals(
                new ProductsPage(driver, false).getCartBadgeText(),
                "2",
                "Product wasn't removed from cart"
        );
    }

    @Test
    public void addProductsAndGoToShoppingCart() {


        List<String> productsAddList = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light");

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(properties.getUserName(), properties.getPassword());

        ProductsSteps productsSteps = new ProductsSteps(driver);
        productsSteps.addProductsAndGoToCart(productsAddList);

        ShoppingCartPage shoppingCart = new ShoppingCartPage(driver, false);

        Assert.assertEquals(
                shoppingCart.getTitleLabel().getText(),
                "YOUR CART",
                "Shopping cart page wasn't opened"
        );
        Assert.assertEquals(
                new ProductsPage(driver, false).getCartBadgeText(),
                "2",
                "Product number on shopping cart is not correct"
        );
        Assert.assertEquals(
                shoppingCart.getCartItemLabels().size(),
                1,
                "Number of products in shopping cart list is not correct"
        );
    }

    @Test
    public void removeShoppingCartProducts() {

        List<String> productsAddList = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt");
        List<String> productsRemoveList = Arrays.asList("Sauce Labs Backpack");

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(properties.getUserName(), properties.getPassword());

        ProductsSteps productsSteps = new ProductsSteps(driver);
        productsSteps.addProductsAndGoToCart(productsAddList);

        ShoppingCartSteps shoppingCartSteps = new ShoppingCartSteps(driver);
        shoppingCartSteps.removeProducts(productsRemoveList);

        Assert.assertEquals(
                new ProductsPage(driver, false).getCartBadgeText(),
                "2",
                "Product wasn't removed from cart"
        );
    }

    @Test
    public void goToCheckoutShoppingCartProducts() {

        List<String> productsAddList = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt");

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(properties.getUserName(), properties.getPassword());

        ProductsSteps productsSteps = new ProductsSteps(driver);
        productsSteps.addProducts(productsAddList);

        ShoppingCartPage shoppingCart = new ShoppingCartPage(driver, true);
        shoppingCart.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver, false);

        Assert.assertEquals(
                new ProductsPage(driver, false).getCartBadgeText(),
                "3",
                "Product wasn't removed from cart"
        );
        Assert.assertTrue(
                checkoutPage.getFirstNameInput().isDisplayed(),
                "First Name is not displayed"
        );
        Assert.assertTrue(
                checkoutPage.getLastNameInput().isDisplayed(),
                "Last Name is not displayed"
        );
        Assert.assertTrue(
                checkoutPage.getPostalCodeInput().isDisplayed(),
                "Postal Code is not displayed"
        );
    }

    @Test
    public void checkoutShoppingCartProducts() {

        List<String> productsAddList = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt");

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(properties.getUserName(), properties.getPassword());

        ProductsSteps productsSteps = new ProductsSteps(driver);
        productsSteps.addProducts(productsAddList);

        ShoppingCartPage shoppingCart = new ShoppingCartPage(driver, true);
        shoppingCart.getCheckoutButton().click();

        CheckoutSteps checkoutSteps = new CheckoutSteps(driver);
        checkoutSteps.fillInCheckoutDataAndSend("User", "Name", "12345");

        CheckoutPage checkoutPage = new CheckoutPage(driver, false);
        checkoutPage.getContinueButton().click();

        Assert.assertEquals(
                new CheckoutOverviewPage(driver, false).getTitleLabel().getText(),
                "CHECKOUT: OVERVIEW",
                "'Checkout Overview' page is not displayed"
        );
        Assert.assertTrue(
                new CheckoutOverviewPage(driver, false).getFinishButton().isDisplayed(),
                "Finish button is not displayed"
        );
    }
}

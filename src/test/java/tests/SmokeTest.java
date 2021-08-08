package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ShoppingCartPage;
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

    @Test
    public void addProductToCart() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUserName(), properties.getPassword());

        ProductsPage product = new ProductsPage(driver, true);
        product.addOrRemoveFromCart("Sauce Labs Backpack");

        Assert.assertEquals(
                product.getCartBadgeText(),
                "1",
                "Product wasn't added to cart"
        );
    }

    @Test
    public void removeProductFromCart() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUserName(), properties.getPassword());

        ProductsPage product = new ProductsPage(driver, false);
        product.addOrRemoveFromCart("Sauce Labs Backpack");
        product.addOrRemoveFromCart("Sauce Labs Bike Light");
        product.addOrRemoveFromCart("Sauce Labs Bolt T-Shirt");

        product.addOrRemoveFromCart("Sauce Labs Backpack");

        Assert.assertEquals(
                product.getCartBadgeText(),
                "2",
                "Product wasn't removed from cart"
        );
    }

    @Test
    public void addProductsAndGoToShoppingCart() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUserName(), properties.getPassword());

        ProductsPage product = new ProductsPage(driver, false);
        product.addOrRemoveFromCart("Sauce Labs Backpack");
        product.getShoppingCartLink().click();

        ShoppingCartPage shoppingCart = new ShoppingCartPage(driver, false);

        Assert.assertEquals(
                shoppingCart.getTitleLabel().getText(),
                "YOUR CART",
                "Shopping cart page wasn't opened"
        );
        Assert.assertEquals(
                product.getCartBadgeText(),
                "1",
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

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUserName(), properties.getPassword());

        ProductsPage product = new ProductsPage(driver, false);
        product.addOrRemoveFromCart("Sauce Labs Backpack");
        product.addOrRemoveFromCart("Sauce Labs Bike Light");
        product.addOrRemoveFromCart("Sauce Labs Bolt T-Shirt");

        ShoppingCartPage shoppingCart = new ShoppingCartPage(driver, true);
        shoppingCart.getRemoveFromCartProductButton("Sauce Labs Backpack");

        Assert.assertEquals(
                product.getCartBadgeText(),
                "2",
                "Product wasn't removed from cart"
        );
    }

    @Test
    public void goToCheckoutShoppingCartProducts() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUserName(), properties.getPassword());

        ProductsPage product = new ProductsPage(driver, false);
        product.addOrRemoveFromCart("Sauce Labs Backpack");
        product.addOrRemoveFromCart("Sauce Labs Bike Light");
        product.addOrRemoveFromCart("Sauce Labs Bolt T-Shirt");

        ShoppingCartPage shoppingCart = new ShoppingCartPage(driver, true);
        shoppingCart.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver, false);

        Assert.assertEquals(
                product.getCartBadgeText(),
                "2",
                "Product wasn't removed from cart"
        );
        Assert.assertTrue(
                checkoutPage.getFirstNameInput().isDisplayed(),
                "First name is not displayed"
        );

    }
}

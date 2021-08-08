package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.ShoppingCartPage;
import steps.LoginStep;

public class ProductsTest extends BaseTest {

    @Test
    public void addProductToCart() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUserName(), properties.getPassword());

        ProductsPage product = new ProductsPage(driver, true);
        product.addOrRemoveFromCart("Sauce Labs Backpack");
        product.addOrRemoveFromCart("Sauce Labs Bike Light");
        product.addOrRemoveFromCart("Sauce Labs Bolt T-Shirt");

        Assert.assertEquals(
                product.getCartBadgeText(),
                "3",
                "Products weren't added to cart"
        );
    }

    @Test(dependsOnMethods = "addProductToCart")
    public void removeProductFromCart() {

        ProductsPage product = new ProductsPage(driver, false);
        product.addOrRemoveFromCart("Sauce Labs Backpack");

        Assert.assertEquals(
                product.getCartBadgeText(),
                "2",
                "Product wasn't removed from cart"
        );
    }

    @Test(dependsOnMethods = "removeProductFromCart")
    public void goToShoppingCart() {

        ProductsPage product = new ProductsPage(driver, false);
        product.getShoppingCartLink().click();

        Assert.assertEquals(
                new ShoppingCartPage(driver, false).getTitleLabel().getText(),
                "YOUR CART",
                "Shopping cart page wasn't opened"
        );
    }
}

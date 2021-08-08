package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;

public class ShoppingCartTest extends BaseTest {

    @Test
    public void removeProductFromShoppingCart() {

        ShoppingCartPage shoppingCart = new ShoppingCartPage(driver, false);
        shoppingCart.getRemoveFromCartProductButton("Sauce Labs Backpack").click();

        Assert.assertEquals(
                shoppingCart.getCartBadgeText(),
                "1",
                "Product wasn't removed from shopping cart"
                );
    }
}

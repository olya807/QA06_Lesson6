package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutCompletionPage;
import pages.LoginPage;
import pages.ShoppingCartPage;
import steps.LoginSteps;

import java.util.ArrayList;
import java.util.List;

public class SmokeTest extends BaseTest {

    @Test
    public void criticalPathTest() {
        CheckoutCompletionPage completionPage = new LoginPage(browsersService, true)
                .setUsername(correctUser.getUsername())
                .setPassword(correctUser.getPassword())
                .successLoginBtnClick()
                .addItemToCart("Sauce Labs Backpack")
                .cartBadgeClick()
                .checkoutButtonClick()
                .setFirstname("Name")
                .setLastname("Surname")
                .setZipcode("220000")
                .continueButtonClick()
                .finishButtonClick();

        Assert.assertEquals(completionPage.getCompletionMessage().trim(), "THANK YOU FOR YOUR ORDER");
    }

    @Test
    public void criticalPathStepsTest() {
        CheckoutCompletionPage completionPage = new LoginSteps(browsersService)
                .successLogin(correctUser)
                .addItemToCart("Sauce Labs Backpack")
                .moveToCart()
                .completeOrder();

        Assert.assertEquals(completionPage.getCompletionMessage().trim(), "THANK YOU FOR YOUR ORDER");
    }

    @Test
    public void loginFailedTest() {
        LoginPage loginPage = new LoginPage(browsersService, true)
                .setUsername(lockedUser.getUsername())
                .setPassword(lockedUser.getPassword())
                .loginBtnClick();

        Assert.assertEquals(loginPage.getErrorMessage().getText().trim(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void removeItemFromCartTest() {
        List<String> itemsList = new ArrayList<>();
        itemsList.add("Sauce Labs Backpack");
        itemsList.add("Sauce Labs Bolt T-Shirt");

        ShoppingCartPage shoppingCartPage = new LoginPage(browsersService, true)
                .setUsername(correctUser.getUsername())
                .setPassword(correctUser.getPassword())
                .successLoginBtnClick()
                .addItemsToCart(itemsList)
                .cartBadgeClick()
                .removeButtonClick(itemsList.get(0));

        Assert.assertEquals(shoppingCartPage.getItemsCount(), 1);
    }

    @Test
    public void removeItemFromCartStepsTest() {
        List<String> itemsList = new ArrayList<>();
        itemsList.add("Sauce Labs Backpack");
        itemsList.add("Sauce Labs Bolt T-Shirt");

        ShoppingCartPage shoppingCartPage = new LoginSteps(browsersService)
                .successLogin(correctUser)
                .addItemsToCart(itemsList)
                .moveToCart()
                .getShoppingCartPage()
                .removeButtonClick(itemsList.get(1));

        Assert.assertEquals(shoppingCartPage.getItemsCount(), 1);
    }
}

package steps;

import base.BaseStep;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;

public class CheckoutSteps extends BaseStep {

    public CheckoutSteps(WebDriver driver) {
        super(driver);
    }

    public CheckoutOverviewPage fillInCheckoutDataAndSend() {

        CheckoutPage checkoutPage = new CheckoutPage(driver, false);
        User user = setupUser();

        checkoutPage.firstName_Input_By.sendKeys(user.getFirstName());
        checkoutPage.lastName_Input_By.sendKeys(user.getLastName());
        checkoutPage.postalCode_Input_By.sendKeys(user.getPostalCode());

        checkoutPage.continue_Button_By.click();

        return new CheckoutOverviewPage(driver, false);
    }

    private User setupUser() {

        User user = new User();
        user.setFirstName(properties.getUserName());
        user.setLastName(properties.getUserLastName());
        user.setPostalCode(properties.getPostalCode());

        return user;
    }
}

package steps;

import base.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;

public class CheckoutSteps extends BaseStep {

    public CheckoutSteps(WebDriver driver) {
        super(driver);
    }

    public void fillInCheckoutDataAndSend(String firstName, String lastName, String postalCode){

        CheckoutPage checkoutPage = new CheckoutPage(driver, false);

        checkoutPage.getFirstNameInput().sendKeys(firstName);
        checkoutPage.getLastNameInput().sendKeys(lastName);
        checkoutPage.getPostalCodeInput().sendKeys(postalCode);

        checkoutPage.getContinueButton().click();
    }
}

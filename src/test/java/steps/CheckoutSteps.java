package steps;

import base.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;

public class CheckoutSteps extends BaseStep {

    public CheckoutSteps(WebDriver driver) {
        super(driver);
    }

    public CheckoutOverviewPage fillInCheckoutDataAndSend(String firstName, String lastName, String postalCode){

        CheckoutPage checkoutPage = new CheckoutPage(driver, false);

        checkoutPage.firstName_Input_By.sendKeys(firstName);
        checkoutPage.lastName_Input_By.sendKeys(lastName);
        checkoutPage.postalCode_Input_By.sendKeys(postalCode);

        checkoutPage.continue_Button_By.click();

        return new CheckoutOverviewPage(driver, false);
    }
}

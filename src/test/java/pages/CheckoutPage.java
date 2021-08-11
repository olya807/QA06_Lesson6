package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

    private final static String endpoint = "checkout-step-one.html";
    private final static By title_Label_By = By.className("title");
    private final static By firstName_Input_By = By.id("first-name");
    private final static By lastName_Input_By = By.id("last-name");
    private final static By postalCode_Input_By = By.id("postal-code");
    private final static By cancel_Button_By = By.className("cancel");
    private final static By continue_Button_By = By.id("continue");

    public CheckoutPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getUrl() + endpoint);
    }

    @Override
    public boolean isPageOpen() {
        try {
            return getTitleLabel().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getTitleLabel() {
        return driver.findElement(title_Label_By);
    }

    public WebElement getFirstNameInput() {
        return driver.findElement(firstName_Input_By);
    }

    public WebElement getLastNameInput() {
        return driver.findElement(lastName_Input_By);
    }

    public WebElement getPostalCodeInput() {
        return driver.findElement(postalCode_Input_By);
    }

    public WebElement getCancelButton() {
        return driver.findElement(cancel_Button_By);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continue_Button_By);
    }
}

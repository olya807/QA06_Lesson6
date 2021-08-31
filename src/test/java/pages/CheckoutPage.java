package pages;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    private final static String endpoint = "checkout-step-one.html";

    //PageFactory Selectors
    @CacheLookup
    @FindBy(className = "title")
    public WebElement title_Label_By;

    @CacheLookup
    @FindBy(id = "first-name")
    public WebElement firstName_Input_By;

    @CacheLookup
    @FindBy(id = "last-name")
    public WebElement lastName_Input_By;

    @CacheLookup
    @FindBy(id = "postal-code")
    public WebElement postalCode_Input_By;

    @CacheLookup
    @FindBy(className = "cancel")
    public WebElement cancel_Button_By;

    @CacheLookup
    @FindBy(id = "continue")
    public WebElement continue_Button_By;

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
            return title_Label_By.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

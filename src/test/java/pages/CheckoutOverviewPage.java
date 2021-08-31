package pages;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

    private final static String endpoint = "checkout-step-two.html";

    //PageFactory Selectors
    @CacheLookup
    @FindBy(className = "title")
    public WebElement title_Label_By;

    @CacheLookup
    @FindBy(id = "cancel")
    public WebElement cancel_Button_By;

    @CacheLookup
    @FindBy(id = "finish")
    public WebElement finish_Button_By;

    public CheckoutOverviewPage(WebDriver driver, boolean openPageByUrl) {
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

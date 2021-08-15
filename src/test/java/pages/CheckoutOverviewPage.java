package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage extends BasePage {

    private final static String endpoint = "checkout-step-two.html";
    private final static By title_Label_By = By.className("title");
    private final static By cancel_Button_By = By.id("cancel");
    private final static By finish_Button_By = By.id("finish");

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
            return getTitleLabel().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getTitleLabel() {
        return driver.findElement(title_Label_By);
    }

    public WebElement getCancelButton() {
        return driver.findElement(cancel_Button_By);
    }

    public WebElement getFinishButton() {
        return driver.findElement(finish_Button_By);
    }
}

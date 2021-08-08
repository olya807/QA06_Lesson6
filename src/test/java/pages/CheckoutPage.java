package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

    private final static String endpoint = "checkout-step-one.html";
    private final static By title_Label_By = By.className("title");
    private final static By firstName_Input_By = By.id("first-name");

    public CheckoutPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpen() {
        return false;
    }

    public WebElement getTitleLabel() {
        return driver.findElement(title_Label_By);
    }

    public WebElement getFirstNameInput() {
        return driver.findElement(firstName_Input_By);
    }
}

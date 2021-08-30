package pages;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage extends BasePage {

    //PageFactory Selectors
    @CacheLookup
    @FindBy(id = "user-name")
    public WebElement username_Input_By;

    @CacheLookup
    @FindBy(id = "password")
    public WebElement password_Input_By;

    @CacheLookup
    @FindAll({
            @FindBy(id = "login-button")
    })
    public WebElement login_Button_By;

    @CacheLookup
    @FindBys({
            @FindBy(css = "form"),
            @FindBy(tagName = "h3")
    })
    public WebElement error_Label_By;

    //Constructors

    public LoginPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getUrl());
    }

    @Override
    public boolean isPageOpen() {

        try {
            return login_Button_By.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //PageFactory atomic methods for work with elements
    public void setUserName(String userName) {
        username_Input_By.sendKeys(userName);
    }

    public void setPassword(String password) {
        password_Input_By.sendKeys(password);
    }

    public void clickLoginButton() {
        login_Button_By.click();
    }
}

package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    //Selectors
    private final static By username_Input_By = By.id("user-name");
    private final static By password_Input_By = By.id("password");
    private final static By login_Button_By = By.id("login-button");
    private final static By error_Label_By = By.tagName("h3");

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
            return getLoginButtonBy().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //Getters

    public WebElement getUsernameInputBy() {
        return driver.findElement(username_Input_By);
    }

    public WebElement getPasswordInputBy() {
        return driver.findElement(password_Input_By);
    }

    public WebElement getLoginButtonBy() {
        return driver.findElement(login_Button_By);
    }

    public WebElement getErrorLabel() {
        return driver.findElement(error_Label_By);
    }


    //Atomic methods for work with elements
    public void setUserName(String userName) {
        getUsernameInputBy().sendKeys(userName);
    }

    public void setPassword(String password) {
        getPasswordInputBy().sendKeys(password);
    }

    public void clickLoginButton() {
        getLoginButtonBy().click();
    }
}

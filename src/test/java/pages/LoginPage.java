package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    //Selectors
    private final static By username_Input_By = By.id("user-name");
    private final static By password_Input_By = By.id("password");
    private final static By login_Button_By = By.id("login-button");

    //Constructors
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        openPage();
    }

    private void openPage(){

        driver.get("https://www.saucedemo.com/");
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


    //Atomic methods for work with elements
    public void setUserName(String userName){
        getUsernameInputBy().sendKeys(userName);
    }

    public void setPassword(String password){
        getPasswordInputBy().sendKeys(password);
    }

    public void clickLoginButton(){
        getLoginButtonBy().click();
    }
}

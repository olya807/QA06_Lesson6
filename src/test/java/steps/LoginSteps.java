package steps;

import base.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginSteps extends BaseStep {

    public LoginSteps(WebDriver driver) {
        super(driver);
    }

    public ProductsPage loginWithCorrectData(){

        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName(properties.getUserName());
        loginPage.setPassword(properties.getPassword());
        loginPage.clickLoginButton();

        return new ProductsPage(driver, false);
    }

    public LoginPage loginWithIncorrectData(String userName, String password){

        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();

        return new LoginPage(driver, false);
    }
}

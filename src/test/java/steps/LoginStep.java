package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginStep extends BaseStep {


    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password){

        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }
}

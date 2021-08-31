package steps;

import baseEntities.BaseStep;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginStep extends BaseStep {


    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password) {

        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }

    public ProjectAddStep loginWithCorrectData() {

        LoginPage loginPage = new LoginPage(driver, true);
        User user = setupUser();

        loginPage.setUserName(user.getUserName());
        loginPage.setPassword(user.getPassword());
        loginPage.clickLoginButton();

        return new ProjectAddStep(driver);
    }

    private User setupUser(){

        User user = new User();
        user.setUserName(properties.getUserName());
        user.setPassword(properties.getPassword());

        return user;
    }
}

package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginStep extends BaseStep {

    private LoginPage loginPage;

    public LoginStep(BrowserService browserService) {
        super(browserService);
        loginPage = new LoginPage(browserService, true);
    }

    @Step("Log in with username {userName} and password {password}")
    public void loginWithCorrectCredentials(String userName, String password) {

        LoginPage loginPage = new LoginPage(browserService, true);
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }

    @Step("Log in with username {userName} and password {password}")
    public void loginWithIncorrectCredentials(String userName, String password) {

        LoginPage loginPage = new LoginPage(browserService, true);
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }
}

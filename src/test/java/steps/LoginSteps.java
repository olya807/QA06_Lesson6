package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import io.qameta.allure.Step;
import models.User;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginSteps extends BaseStep {

    private LoginPage loginPage;

    public LoginSteps(BrowserService browserService) {
        super(browserService);
        loginPage = new LoginPage(browserService, true);
    }

    @Step("Log in with username {userName} and password {password}")
    public DashboardPage loginWithCorrectCredentials(String userName, String password) {

        fillInDataAndLogIn(userName, password);

        return new DashboardPage(browserService, false);
    }

    @Step("Log in with username {userName} and password {password}")
    public DashboardPage loginWithCorrectCredentials(User user) {

        fillInDataAndLogIn(user.getEmail(), user.getPassword());

        return new DashboardPage(browserService, false);
    }

    @Step("Log in with username {userName} and password {password}")
    public LoginPage loginWithIncorrectCredentials(String userName, String password) {

        fillInDataAndLogIn(userName, password);

        return new LoginPage(browserService, false);
    }

    private void fillInDataAndLogIn(String userName, String password){

        LoginPage loginPage = new LoginPage(browserService, true);
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }
}
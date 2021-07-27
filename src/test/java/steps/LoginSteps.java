package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginSteps extends BaseStep {

    public LoginSteps(WebDriver driver) {
        super(driver);
    }

    public DashboardPage loginWithCorrectCredentials(String email, String psw) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(psw);
        loginPage.getLoginButton().click();

        return new DashboardPage(driver, false);
    }

    public LoginPage loginWithIncorrectCredentials(String email, String psw) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(psw);
        loginPage.getLoginButton().click();

        return new LoginPage(driver, false);
    }
}

package pages;

import baseEntities.BasePage;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static String END_POINT = "index.php?/auth/login/";

    private static final By emailInputBy = By.id("name");
    private static final By passwordInputBy = By.id("password");
    private static final By loginButtonBy = By.id("button_primary");
    private static final By errorLabelBy = By.className("error-text");

    private static final By emailIsRequiredLabelBy = By.xpath("//div[contains(text(), 'Email/Login is required')]");
    private static final By passwordIsRequiredLabelBy = By.xpath("//div[contains(text(), 'Password is required')]");

    public LoginPage(WebDriver browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getUrl() + END_POINT);
    }

    @Override
    public boolean isPageOpen() {
        try {
            return new UIElement(driver, By.id("button_primary")).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public UIElement getEmailInput() {
        return new UIElement(driver, emailInputBy);
    }

    public UIElement getPasswordInput() {
        return new UIElement(driver, passwordInputBy);
    }

    public UIElement getLoginButton() {
        return new UIElement(driver, loginButtonBy);
    }

    public String getErrorText() {
        return new UIElement(driver, errorLabelBy).getText();
    }

    public UIElement getEmailIsRequiredLabel() {
        return new UIElement(driver, emailIsRequiredLabelBy);
    }

    public UIElement getPasswordIsRequiredLabel() {
        return new UIElement(driver, passwordIsRequiredLabelBy);
    }

}

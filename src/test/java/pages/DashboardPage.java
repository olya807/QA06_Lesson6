package pages;

import base.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    private final static String endpoint = "/index.php?/dashboard";
    private final static By title_Label_By = By.id("navigation-dashboard");
    private final static By addProject_Button_By = By.className("sidebar-button");

    public DashboardPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getUrl() + endpoint);
    }

    @Override
    public boolean isPageOpen() {
        try {
            return getTitleLabel().getText().toLowerCase().trim().equals("dashboard");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getTitleLabel() {
        return driver.findElement(title_Label_By);
    }

    public WebElement getAddProjectButtonBy() {
        return driver.findElement(addProject_Button_By);
    }
}

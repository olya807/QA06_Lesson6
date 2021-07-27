package pages;

import baseEntities.BasePage;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private static final String END_POINT = "index.php?/dashboard";
    protected static final By sidebarProjectsAddButtonBy = By.id("sidebar-projects-add");

    public DashboardPage(WebDriver browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getUrl() + END_POINT);
    }

    @Override
    public boolean isPageOpen() {
        try {
            return getSidebarProjectsAddButton().isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public UIElement getSidebarProjectsAddButton() {
        return new UIElement(driver, sidebarProjectsAddButtonBy);
    }

}

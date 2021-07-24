package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContextMenuPage extends BasePage {

    private final static By pageTitle = By.tagName("h3");
    private final static By hotSpot = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {

        driver.get(properties.getBaseUrl() + "/context_menu");
    }

    @Override
    public boolean isPageOpen() {

        try {
            return getTitleText().equals("Context Menu");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getTitle() {

        return waits.waitForVisibility(pageTitle);
    }

    public String getTitleText() {

        return getTitle().getText();
    }

    public WebElement getHotSpot() {

        return waits.waitForVisibility(hotSpot);
    }

    public String getAlertText() {

        return waits.waitForAlert().getText();
    }
}

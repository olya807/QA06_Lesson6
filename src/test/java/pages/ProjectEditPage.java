package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectEditPage extends BasePage {

    private final static String endpoint = "/index.php?/admin/projects/edit";
    private final static By title_Label_By = By.className("page_title");
    private final static By name_Input_By = By.id("name");
    private final static By announcement_TextArea_By = By.id("announcement");
    private final static By saveProject_Button_By = By.id("accept");

    public ProjectEditPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {

        driver.get(properties.getUrl() + endpoint);
    }

    @Override
    public boolean isPageOpen() {

        try {
            return getTitleLabel().getText().toLowerCase().trim().equals("edit project");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getTitleLabel() {

        return driver.findElement(title_Label_By);
    }

    public WebElement getAnnouncementTextArea() {

        return driver.findElement(announcement_TextArea_By);
    }

    public WebElement getProjectNameInput() {

        return driver.findElement(name_Input_By);
    }

    public WebElement getSaveProjectButton() {

        return driver.findElement(saveProject_Button_By);
    }
}

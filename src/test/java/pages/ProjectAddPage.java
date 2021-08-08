package pages;

import baseEntities.BasePage;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ProjectAddPage extends BasePage {

    @FindBys({
            @FindBy(className = "form-group"),
            @FindBy(css = "input.form-control[name = 'name']")
    })
    public WebElement name;

    @FindBys({
            @FindBy(className = "form-group"),
            @FindBy(css = "input.form-control[name = 'name']")
    })
    public List<WebElement> nameList;

    @FindAll({
            @FindBy(id = "suite_mode_single"),
            @FindBy(id = "suite_mode_single_baseline"),
            @FindBy(id = "suite_mode_multi")
    })
    public List<WebElement> optionsList;

    private final static String endpoint = "/index.php?/admin/projects/add";
    private final static By title_Label_By = By.className("page_title");
    private final static By name_Input_By = By.id("name");
    private final static By announcement_TextArea_By = By.id("announcement");
    private final static By addProject_Button_By = By.id("accept");

    public ProjectAddPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }

    @Override
    protected void openPage() {

        driver.get(properties.getUrl() + endpoint);
    }

    @Override
    public boolean isPageOpen() {

        try {
            return getTitleLabel().getText().toLowerCase().trim().equals("add project");
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

    public WebElement getAddProjectButton() {

        return driver.findElement(addProject_Button_By);
    }
}

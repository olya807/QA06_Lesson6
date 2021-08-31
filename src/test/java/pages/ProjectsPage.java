package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import steps.ProjectEditStep;

public class ProjectsPage extends BasePage {

    private final static String endpoint = "/index.php?/admin/projects/overview";
    private final static By title_Label_By = By.className("page_title");
    private final static By success_Text_By = By.className("message-success");
    private final static String project_TableRow_By_Text = "//table//a[text()='project_name']";
    private final static String action_ProjectTableRow_Button_By = "//tr[td/a[text()='project_name']]/td[a/div[@class='icon-small-action']]";
    private final static By delete_Checkbox_By = By.cssSelector("#deleteDialog input[name='deleteCheckbox']");
    private final static By ok_Button_By = By.cssSelector("#deleteDialog .button-ok");

    public ProjectsPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {

        driver.get(properties.getUrl() + endpoint);
    }

    @Override
    public boolean isPageOpen() {

        try {
            return getTitleLabel().getText().toLowerCase().trim().equals("projects");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getTitleLabel() {

        return driver.findElement(title_Label_By);
    }

    public WebElement getSuccessText() {

        return driver.findElement(success_Text_By);
    }

    public WebElement getProjectNameTableRow(String projectName) {

        return driver.findElement(By.xpath(project_TableRow_By_Text.replace("project_name", projectName)));
    }

    public WebElement getDeleteProjectButtonTableRow(String projectName) {

        return driver.findElement(By.xpath(action_ProjectTableRow_Button_By
                        .replace("project_name", projectName)
                        .replace("action", "delete"))
        );
    }

    public WebElement getEditProjectButtonTableRow(String projectName) {

        return driver.findElement(By.xpath(action_ProjectTableRow_Button_By
                .replace("project_name", projectName)
                .replace("action", "edit"))
        );
    }

    public WebElement getDeleteProjectCheckbox() {

        return driver.findElement(delete_Checkbox_By);
    }

    public WebElement getOkButton() {

        return driver.findElement(ok_Button_By);
    }

    public ProjectEditStep clickEditProjectButtonTableRow(String projectName) {

        getEditProjectButtonTableRow(projectName).click();

        return new ProjectEditStep(driver);
    }

    public ProjectsPage clickDeleteProjectButtonTableRow(String projectName) {

        getDeleteProjectButtonTableRow(projectName).click();

        return new ProjectsPage(driver, false);
    }

    public ProjectsPage clickDeleteProjectCheckbox() {

        getDeleteProjectCheckbox().click();

        return new ProjectsPage(driver, false);
    }

    public ProjectsPage clickOkButton() {

        getOkButton().click();

        return new ProjectsPage(driver, false);
    }
}

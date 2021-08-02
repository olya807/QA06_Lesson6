package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.ProjectAddPage;

public class ProjectAddStep extends BaseStep {

    public ProjectAddStep(WebDriver driver) {
        super(driver);
    }

    public void addProjectDataAndSave(String projectName, String announcementText) {

        ProjectAddPage projectAddPage = new ProjectAddPage(driver, true);
        projectAddPage.getProjectNameInput().clear();
        projectAddPage.getProjectNameInput().sendKeys(projectName);
        projectAddPage.getAnnouncementTextArea().clear();
        projectAddPage.getAnnouncementTextArea().sendKeys(announcementText);
        projectAddPage.getAddProjectButton().click();
    }
}

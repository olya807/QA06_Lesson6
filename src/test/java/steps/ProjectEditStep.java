package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.ProjectEditPage;
import pages.ProjectsPage;

public class ProjectEditStep extends BaseStep {

    public ProjectEditStep(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage editProjectDataAndSave(String projectName, String announcementText) {

        ProjectEditPage projectEditPage = new ProjectEditPage(driver, false);
        projectEditPage.getProjectNameInput().clear();
        projectEditPage.getProjectNameInput().sendKeys(projectName);
        projectEditPage.getAnnouncementTextArea().clear();
        projectEditPage.getAnnouncementTextArea().sendKeys(announcementText);
        projectEditPage.getSaveProjectButton().click();

        return new ProjectsPage(driver, false);
    }
}

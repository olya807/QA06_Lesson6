package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import pages.ProjectAddPage;

public class ProjectAddStep extends BaseStep {

    public ProjectAddStep(BrowserService browserService) {
        super(browserService);
    }

    public void addProjectDataAndSave(String projectName, String announcementText) {

        ProjectAddPage projectAddPage = new ProjectAddPage(browserService, true);
        projectAddPage.getProjectNameInput().clear();
        projectAddPage.getProjectNameInput().sendKeys(projectName);
        projectAddPage.getAnnouncementTextArea().clear();
        projectAddPage.getAnnouncementTextArea().sendKeys(announcementText);
        projectAddPage.getAddProjectButton().click();
    }
}

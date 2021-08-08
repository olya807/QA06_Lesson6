package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import pages.ProjectEditPage;

public class ProjectEditStep extends BaseStep {

    private ProjectEditStep projectEditStep;

    public ProjectEditStep(BrowserService browserService) {
        super(browserService);
        projectEditStep = new ProjectEditStep(browserService);
    }

    public void editProjectDataAndSave(String projectName, String announcementText) {

        ProjectEditPage projectEditPage = new ProjectEditPage(browserService, false);
        projectEditPage.getProjectNameInput().clear();
        projectEditPage.getProjectNameInput().sendKeys(projectName);
        projectEditPage.getAnnouncementTextArea().clear();
        projectEditPage.getAnnouncementTextArea().sendKeys(announcementText);
        projectEditPage.getSaveProjectButton().click();
    }
}

package steps;

import baseEntities.BaseStep;
import core.BrowserService;
import pages.DashboardPage;
import pages.ProjectAddPage;
import pages.ProjectEditPage;

public class ProjectSteps extends BaseStep {

    private ProjectSteps projectSteps;

    public ProjectSteps(BrowserService browserService) {
        super(browserService);
        projectSteps = new ProjectSteps(browserService);
    }

    public DashboardPage addProjectDataAndSave(String projectName, String announcementText) {

        ProjectAddPage projectAddPage = new ProjectAddPage(browserService, true);
        projectAddPage.getProjectNameInput().clear();
        projectAddPage.getProjectNameInput().sendKeys(projectName);
        projectAddPage.getAnnouncementTextArea().clear();
        projectAddPage.getAnnouncementTextArea().sendKeys(announcementText);
        projectAddPage.getAddProjectButton().click();

        return new DashboardPage(browserService, false);
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

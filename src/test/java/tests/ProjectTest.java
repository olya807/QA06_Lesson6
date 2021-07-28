package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.ProjectEditPage;
import pages.ProjectsPage;
import steps.ProjectAddStep;
import steps.LoginStep;
import steps.ProjectEditStep;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectTest extends BaseTest {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
    final String projectName = String.format("TestProject_%s", simpleDateFormat.format(new Date()));
    final String projectNameEdited = projectName + "_edited";

    @Test
    public void loginTest() {

        new LoginStep(driver).login(properties.getUserName(), properties.getPassword());

        Assert.assertTrue(
                new DashboardPage(driver, false).isPageOpen(),
                "'Dashboard' page is not opened."
        );
    }

    @Test(dependsOnMethods = "loginTest")
    public void addProjectTest() {

        new ProjectAddStep(driver).addProjectDataAndSave(projectName, "Test Announcement");

        Assert.assertEquals(
                new ProjectsPage(driver, false).getSuccessText().getText(),
                "Successfully added the new project.",
                "'Success' message wasn't found."
        );
        Assert.assertTrue(
                new ProjectsPage(driver, false).getProjectNameTableRow(projectName).isDisplayed(),
                String.format("Project '%s' is not found on 'Projects' page.", projectName)
        );
    }

    @Test(dependsOnMethods = "addProjectTest")
    public void editProjectClickTest() {

        new ProjectsPage(driver, false).getEditProjectButtonTableRow(projectName).click();

        Assert.assertTrue(
                new ProjectEditPage(driver, false).isPageOpen(),
                "'Projects' page is not opened."
        );
    }

    @Test(dependsOnMethods = "editProjectClickTest")
    public void editProjectDataTest() {

        new ProjectEditStep(driver).editProjectDataAndSave(
                projectNameEdited,
                "Test Announcement edited"
        );

        Assert.assertTrue(
                new ProjectsPage(driver, false).getProjectNameTableRow(projectNameEdited).isDisplayed(),
                String.format("Project '%s' is not found on 'Projects' page.", projectNameEdited)
        );
    }

    @Test(dependsOnMethods = "editProjectDataTest")
    public void deleteProjectTest() {

        ProjectsPage projectsPage = new ProjectsPage(driver, false);
        projectsPage.getDeleteProjectButtonTableRow(projectNameEdited).click();

        projectsPage.getDeleteProjectCheckbox().click();
        projectsPage.getOkButton().click();

        Assert.assertEquals(
                projectsPage.getSuccessText().getText(),
                "Successfully deleted the project.",
                "'Success' message wasn't found."
        );
    }
}

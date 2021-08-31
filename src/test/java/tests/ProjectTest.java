package tests;

import baseEntities.BaseTest;
import models.ProjectBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectsPage;
import steps.LoginStep;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectTest extends BaseTest {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSS");
    final String projectName = String.format("TestProject_%s", simpleDateFormat.format(new Date()));
    final String projectNameEdited = projectName + "_edited";

    @Test
    public void chainOfInvocationsStepLevelTest() {

        ProjectBuilder projectBuilder = setupProjectBuilder();

        new LoginStep(driver)
                .loginWithCorrectData()
                .addProjectDataAndSave(projectBuilder.getProjectName(), projectBuilder.getProjectAnnouncementText())
                .clickEditProjectButtonTableRow(projectBuilder.getProjectName())
                .editProjectDataAndSave(projectBuilder.getProjectEditName(), projectBuilder.getProjectAnnouncementEditText())
                .clickDeleteProjectButtonTableRow(projectBuilder.getProjectEditName())
                .clickDeleteProjectCheckbox()
                .clickOkButton();

        Assert.assertEquals(
                new ProjectsPage(driver, false).getSuccessText().getText(),
                "Successfully deleted the project.",
                "'Success' message wasn't found."
        );
    }

    private ProjectBuilder setupProjectBuilder() {

        return new ProjectBuilder.Builder()
                .withProjectName(projectName)
                .withProjectEditName(projectNameEdited)
                .withAnnouncementText("Test Announcement")
                .withAnnouncementEditText("Test Announcement edited")
                .build();
    }
}

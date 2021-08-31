package tests;

import baseEntities.BaseTest;
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

        new LoginStep(driver)
                .loginWithCorrectData()
                .addProjectDataAndSave(projectName, "Test Announcement")
                .clickEditProjectButtonTableRow(projectName)
                .editProjectDataAndSave(projectNameEdited, "Test Announcement edited")
                .clickDeleteProjectButtonTableRow(projectNameEdited)
                .clickDeleteProjectCheckbox()
                .clickOkButton();

        Assert.assertEquals(
                new ProjectsPage(driver, false).getSuccessText().getText(),
                "Successfully deleted the project.",
                "'Success' message wasn't found."
        );
    }
}

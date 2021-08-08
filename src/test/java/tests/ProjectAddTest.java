package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.ProjectAddPage;
import steps.LoginSteps;

public class ProjectAddTest extends BaseTest {

    @Test
    public void pageFactoryTest1() throws InterruptedException {

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps
                .loginWithCorrectCredentials("atrostyanko+0601@gmail.com", "hYE/RiquvQVIzXfiBwm3")
                .getAddProjectButtonBy().click();

        ProjectAddPage projectAddPage = new ProjectAddPage(browserService, false);
        projectAddPage.name.sendKeys("Test Project");

        System.out.println(
                projectAddPage.nameList.size()
        );
        System.out.println(
                projectAddPage.optionsList.size()
        );

        projectAddPage.optionsList.get(1).click();

        Thread.sleep(3000);
    }
}

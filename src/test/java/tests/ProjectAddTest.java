package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.ProjectAddPage;
import steps.LoginStep;

public class ProjectAddTest extends BaseTest {

    @Test
    public void pageFactoryTest1() throws InterruptedException {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login("atrostyanko+0601@gmail.com", "hYE/RiquvQVIzXfiBwm3");

        DashboardPage dashboardPage = new DashboardPage(driver, false);
        dashboardPage.getAddProjectButtonBy().click();

        ProjectAddPage projectAddPage = new ProjectAddPage(driver, false);
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

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import steps.LoginStep;

public class LoginPositiveTest extends BaseTest {

    @Test(description = "TestRail positive login test")
    public void positiveLoginTest() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUserName(), properties.getPassword());

        Assert.assertTrue(
                new DashboardPage(driver, false).isPageOpen(),
                "'Dashboard' page is not opened."
        );
    }

    @Test(description = "Attachment on Fail test")
    public void positiveLoginAttachmentOnFailTest() {

        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(properties.getUserName(), properties.getPassword());

        Assert.assertTrue(
                false
        );
    }
}

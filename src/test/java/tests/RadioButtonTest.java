package tests;

import baseEntities.BaseTest;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.LoginSteps;

public class RadioButtonTest extends BaseTest {

    @Test
    public void radioButtonTest1() throws InterruptedException {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginWithCorrectCredentials(properties.getUserName(), properties.getPassword());

        driver.get("https://aqa06onl02.testrail.io/index.php?/admin/projects/add");

        RadioButton radioButton = new RadioButton(driver, By.name("suite_mode"));
        radioButton.selectByIndex(2);
        radioButton.selectByText("Use multiple test suites to manage cases");

        Thread.sleep(5000);
    }
}

package tests;

import baseEntities.BaseTest;
import elements.Dropdown;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginSteps;

public class DropdownTest extends BaseTest {

    @Test
    public void dropdownTest1() throws InterruptedException {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginWithCorrectCredentials(properties.getUserName(), properties.getPassword());

        Dropdown dropdown = new Dropdown(driver);
        dropdown.clickDropDownByNameAndMenuValue("Help & Feedback", "About TestRail");
        Thread.sleep(3000);

        Assert.assertTrue(
                driver.findElement(By.id("ui-dialog-title-aboutDialog")).isDisplayed()
        );
    }

    @Test
    public void dropdownTest2() throws InterruptedException {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.loginWithCorrectCredentials(properties.getUserName(), properties.getPassword());

        Dropdown dropdown = new Dropdown(driver);
        dropdown.clickDropDownByNameAndMenuValue("Alex Tros", "My Settings");
        Thread.sleep(3000);

        Assert.assertEquals(
                driver.findElement(By.cssSelector(".content-header-title.page_title")).getText().trim(),
                "My Settings");
    }
}

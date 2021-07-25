package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControlsTest1() {

        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver, true);

        Assert.assertTrue(
                dynamicControlsPage.getCheckBox().isDisplayed()
        );
    }

    @Test(dependsOnMethods = "dynamicControlsTest1")
    public void dynamicControlsTest2() {

        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver, false);

        dynamicControlsPage.getButtonRemove().click();

        Assert.assertTrue(
                dynamicControlsPage.getCheckBoxMessage().isDisplayed(),
                "Remove CheckBox Message is not displayed."
        );
        Assert.assertEquals(
                dynamicControlsPage.getCheckBoxMessage().getText(),
                "It's gone!",
                "Remove CheckBox Message is not correct."
        );
        Assert.assertTrue(
                dynamicControlsPage.isCheckBoxInvisible(),
                "CheckBox is visible."
        );
        Assert.assertTrue(
                dynamicControlsPage.isInputDisabled(),
                "Input is not disabled (my check)."
        );
        Assert.assertFalse(
                dynamicControlsPage.getInput().isEnabled(),
                "Input is not disabled."
        );
    }

    @Test(dependsOnMethods = "dynamicControlsTest2")
    public void dynamicControlsTest3() {

        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver, false);

        dynamicControlsPage.getButtonDisableOrEnable().click();
        String actualText = dynamicControlsPage.getInputMessage().getText();
        String expectedText = "It's enabled!";

        Assert.assertEquals(
                actualText,
                expectedText,
                String.format("Wrong message text. Expected '%s' but was '%s'", expectedText, actualText)
        );
        Assert.assertFalse(
                dynamicControlsPage.isInputDisabled(),
                "Input is disabled (my check)."
        );
        Assert.assertTrue(
                dynamicControlsPage.getInput().isEnabled(),
                "Input is disabled."
        );
    }
}

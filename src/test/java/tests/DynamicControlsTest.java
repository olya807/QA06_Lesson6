package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControlsTest() {

        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver, true);

        Assert.assertTrue(
                dynamicControlsPage.getCheckBox().isDisplayed()
        );

        ///

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
                "Input is not disabled."
        );

        ///

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
                "Input is disabled."
        );
    }
}

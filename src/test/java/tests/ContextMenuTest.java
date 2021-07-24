package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class ContextMenuTest extends BaseTest {

    @Test
    public void contextMenuTest() {

        String expectedAlertText = "You selected a context menu";
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver, true);

        Actions actions = new Actions(driver);
        actions
                .moveToElement(contextMenuPage.getHotSpot())
                .contextClick()
                .build().perform();

        String actualAlertText = contextMenuPage.getAlertText();

        Assert.assertEquals(
                actualAlertText,
                expectedAlertText,
                String.format("Alert text is not correct.Expected '%s' but was '%s'.", expectedAlertText, actualAlertText)
        );
    }
}

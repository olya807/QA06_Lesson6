package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class AdvancedElementsTest extends BaseTest {

    @Test
    public void HoverTest() {

        driver.get("http://the-internet.herokuapp.com/hovers");

        List<WebElement> list = driver.findElements(By.className("figure"));

        Actions action = new Actions(driver);
        action
                .moveToElement(list.get(0))
                .pause(1000)
                .moveToElement(list.get(2))
                .pause(1000)
                .moveToElement(list.get(0))
                .build().perform();
    }
}

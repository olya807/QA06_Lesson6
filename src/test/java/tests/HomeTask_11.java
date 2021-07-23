package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HomeTask_11 extends BaseTest {

    @Test
    public void contextMenuTest() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement hot_Spot = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(hot_Spot)
                .contextClick()
                .build().perform();
        Thread.sleep(3000);
    }
    /*
    @Test
    public void dynamicControlsTest() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

    }*/

    @Test
    public void uploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement fileUploader = driver.findElement(By.xpath(""));
        ClassLoader classLoader = getClass().getClassLoader();

    }
}

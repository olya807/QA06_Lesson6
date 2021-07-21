package tests;

import baseEntities.BasePage;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTask_12 extends BasePage {

    public HomeTask_12(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Test
    public void simpleAlertTest() {
        driver.get("http://the-intern.herokuapp.com/javascript_alerts");

        WebElement simpleAlertButton = waits.waitForVisibility(By.xpath("//button[.='Click for JS Alert']"));
        simpleAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement textResult = waits.waitForVisibility(By.id("result"));
        Assert.assertEquals(textResult.getText(), "You successfully clicked an Alert");
    }

    @Test
    public void mediumAlertTest() {
        driver.get("http://the-intern.herokuapp.com/javascript_alerts");

        WebElement mediumAlertButton = waits.waitForVisibility(By.xpath("//button[.='Click for JS Confirm']"));
        mediumAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement textResult = waits.waitForVisibility(By.id("result"));
        Assert.assertEquals(textResult.getText(), "You clicked: Cancel");
    }

    @Test
    public void highAlertTest() {
        driver.get("http://the-intern.herokuapp.com/javascript_alerts");

        WebElement highAlertButton = waits.waitForVisibility(By.xpath("//button[.='Click for JS Prompt']"));
        highAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello World!");
        alert.accept();
        WebElement textResult = waits.waitForVisibility(By.id("result"));
        Assert.assertEquals(textResult.getText(), "You entered: Hello World!");
    }

    @Test
    public void iFrameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");

        WebElement inputTextMessage = waits.waitForVisibility(By.tagName("p"));
        inputTextMessage.clear();
        inputTextMessage.sendKeys("Hello World!");

        driver.switchTo().defaultContent();

        WebElement button = waits.waitForVisibility(By.xpath("//button[@title = 'Align center']"));
        button.click();
    }

    @Test
    public void iFrameTest2() {
        driver.get("https://www.onliner.by/");

        WebElement search = waits.waitForVisibility(By.className("fast-search__input"));
        search.sendKeys("Фильмы", Keys.ENTER);
        WebElement iFrame = waits.waitForVisibility(By.xpath("//iframe[@class= 'modal-iframe']"));
        driver.switchTo().frame(iFrame);

        List<WebElement> productTitle = waits.waitForVisibilityAllElements(By.className("product__title-link"));
        String firstElementText = productTitle.get(0).getText();

        search.clear();
        search.sendKeys(firstElementText, Keys.ENTER);

        System.out.println(firstElementText);

    }

    @Test
    public void demoQaTest () throws InterruptedException {
        driver.get("https://demoqa.com/frames");

        WebElement iFrame = driver.findElement(By.id("frame2"));
        JavascriptExecutor javaScript = (JavascriptExecutor) driver;
        javaScript.executeScript("arguments[0].scrollIntoView();", iFrame);
        driver.switchTo().frame("frame2");
        javaScript.executeScript("window.scrollTo");
        Thread.sleep(3000);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame1");
        WebElement frame1 = waits.waitForVisibility(By.id("sampleHeading"));
        Assert.assertEquals(frame1.getText(), "This is a sample page");
    }

    @Test
    public void demoQaTest1 () {
        driver.get("https://demoqa.com/alerts");

        WebElement simpleAlertButton = waits.waitForVisibility(By.id("alertButton"));
        simpleAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertTrue(waits.waitForNoAlert());
    }

    @Test
    public void demoQaTest2 () {
        driver.get("https://demoqa.com/alerts");

        WebElement simpleAlertAfter5SecButton = waits.waitForVisibility(By.id("timerAlertButton"));
        simpleAlertAfter5SecButton.click();
        waits.waitForAlert();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Assert.assertTrue(waits.waitForNoAlert());
    }

    @Test
    public void demoQaTest3 () {
        driver.get("https://demoqa.com/alerts");

        WebElement mediumAlertButton = waits.waitForVisibility(By.id("confirmButton"));
        mediumAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement textResult = waits.waitForVisibility(By.id("confirmButton"));
        Assert.assertEquals(textResult.getText(), "You selected: Cancel");
    }

    @Test
    public void demoQaTest4 () {
        driver.get("https://demoqa.com/alerts");

        WebElement hurdAlertButton = waits.waitForVisibility(By.id("promtButton"));
        hurdAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello World!");
        alert.accept();
        WebElement textResult = waits.waitForVisibility(By.id("promtButton"));
        Assert.assertEquals(textResult.getText(), "You entered: Hello World!");
    }


    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
}
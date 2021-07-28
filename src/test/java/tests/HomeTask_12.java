package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTask_12 extends BaseTest {

    @Test
    public void simpleAlertTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(5000);

        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        simpleAlertButton.click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement resultLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

        Assert.assertEquals(
                resultLabel.getText(),
                "You successfully clicked an alert"
        );
    }

    @Test
    public void mediumAlertTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(5000);

        WebElement mediumAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        mediumAlertButton.click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement resultLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

        Assert.assertEquals(
                resultLabel.getText(),
                "You clicked: Cancel"
        );
    }

    @Test
    public void hardAlertTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(5000);

        WebElement highAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        highAlertButton.click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello World!");
        alert.accept();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement resultLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

        Assert.assertEquals(
                resultLabel.getText(),
                "You entered: Hello World!"
        );
    }

    @Test
    public void iFrameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");

        WebElement inputTextMessage = driver.findElement(By.tagName("p"));
        inputTextMessage.clear();
        inputTextMessage.sendKeys("Hello World!");

        driver.switchTo().defaultContent();

        WebElement button = driver.findElement(By.xpath("//button[@title = 'Align center']"));
        button.click();

        Assert.assertEquals(
                button.getAttribute("aria-pressed"),
                "true"
        );
    }

    @Test
    public void iFrameTest2() throws InterruptedException {
        driver.get("https://www.onliner.by/");
        Thread.sleep(5000);

        WebElement search = driver.findElement(By.className("fast-search__input"));
        search.sendKeys("Фильмы", Keys.ENTER);
        Thread.sleep(5000);

        WebElement iFrame = driver.findElement(By.xpath("//iframe[@class= 'modal-iframe']"));
        driver.switchTo().frame(iFrame);

        List<WebElement> productTitle = driver.findElements(By.className("product__title-link"));
        String firstElementText = productTitle.get(0).getText();

        driver.switchTo().parentFrame();
        search.clear();
        search.sendKeys(firstElementText, Keys.ENTER);
        Thread.sleep(5000);

        System.out.println(firstElementText);

        Assert.assertFalse(
                firstElementText.isEmpty()
        );
    }

    @Test
    public void demoQaTest() throws InterruptedException {
        driver.get("https://demoqa.com/frames");

        WebElement iFrame = driver.findElement(By.id("frame2"));
        JavascriptExecutor javaScript = (JavascriptExecutor) driver;
        javaScript.executeScript("arguments[0].scrollIntoView();", iFrame);
        driver.switchTo().frame("frame2");
        javaScript.executeScript("window.scrollTo");
        Thread.sleep(3000);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame1");
        WebElement frame1 = driver.findElement(By.id("sampleHeading"));

        Assert.assertEquals(
                frame1.getText(),
                "This is a sample page"
        );
    }

    @Test
    public void demoQaTest1() {
        driver.get("https://demoqa.com/alerts");

        WebElement simpleAlertButton = driver.findElement(By.id("alertButton"));
        simpleAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        Assert.assertTrue(
                wait.until(
                        ExpectedConditions.not(ExpectedConditions.alertIsPresent())
                )
        );
    }

    @Test
    public void demoQaTest2() {
        driver.get("https://demoqa.com/alerts");

        WebElement simpleAlertAfter5SecButton = driver.findElement(By.id("timerAlertButton"));
        simpleAlertAfter5SecButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        Assert.assertTrue(
                wait.until(
                        ExpectedConditions.not(ExpectedConditions.alertIsPresent())
                )
        );
    }

    @Test
    public void demoQaTest3() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        WebElement mediumAlertButton = driver.findElement(By.id("confirmButton"));
        mediumAlertButton.click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.dismiss();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement resultLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmResult")));

        Assert.assertEquals(resultLabel.getText(), "You selected Cancel");
    }

    @Test
    public void demoQaTest4() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        List<WebElement> hardAlertButton = driver.findElements(By.xpath("//button[.='Click me']"));
        hardAlertButton.get(hardAlertButton.size() - 1).click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("Hello World!");
        alert.accept();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement resultLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("promptResult")));

        Assert.assertEquals(
                resultLabel.getText(),
                "You entered Hello World!"
        );
    }
}
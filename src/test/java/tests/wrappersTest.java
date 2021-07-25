package tests;

import baseEntities.BaseTest;
import elements.Button;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class wrappersTest extends BaseTest {

    @Test
    public void buttonTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        Button simpleAlertButton = new Button(driver, By.xpath("//button[. = 'Click for JS Confirm']"));
        simpleAlertButton.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement resultLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));

        Assert.assertEquals(resultLabel.getText(), "You clicked: Cancel");
    }
}

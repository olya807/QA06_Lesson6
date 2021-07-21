package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waits {
    public boolean waitForNoAlert;
    private WebDriverWait wait;

    public Waits(WebDriver driver, int timeOut) {
        wait = new WebDriverWait(driver, timeOut);
    }

    public WebElement waitForVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForPresent(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> waitForVisibilityAllElements(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public Boolean waitForInvisibility(By by) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public Boolean waitForInvisibility(WebElement webElement) {
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public Boolean waitForAttribute(By by, String attributeName, String attributeValue) {
        return wait.until(ExpectedConditions.attributeToBe(by, attributeName, attributeValue));
    }

    public Boolean waitForWindows(int windowCount) {
        try {
            return wait.until(ExpectedConditions.numberOfWindowsToBe(windowCount));
        } catch (TimeoutException ex) {
            return false;
        }
    }
    public List<WebElement> waitForPresentElements(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    public void waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public boolean waitForNoAlert() {
        return wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
    }
}

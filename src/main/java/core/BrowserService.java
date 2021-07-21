package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserService {

    private ReadProperties properties = new ReadProperties();
    private WebDriver driver;
    private Waits wait;

    public BrowserService() {

        switch (properties.getBrowser().toLowerCase()) {

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("disable-gpu");
                chromeOptions.addArguments("start-maximized");
                chromeOptions.setHeadless(properties.getHeadless());

                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(properties.getHeadless());

                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "ie":
                WebDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new AssertionError("The browser is not supported.");
        }

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

        wait = new Waits(driver, properties.getTimeOut());
    }

    public WebDriver getDriver() { return driver; }

    public Waits getWait() {
        return wait;
    }
}

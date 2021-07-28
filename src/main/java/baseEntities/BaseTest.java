package baseEntities;

import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;
    protected ReadProperties properties;

    @BeforeClass
    public void setupClass() {

        System.out.println("BeforeClass works...");
        properties = new ReadProperties();
        driver = new BrowserService().getDriver();
    }

    @AfterClass
    public void tearDownClass() {

        System.out.println("AfterClass works...");
        driver.quit();
    }

    @BeforeTest
    public void setupTest() {

        System.out.println("BeforeTest works...");
        //properties = new ReadProperties();
    }

    @BeforeMethod
    public void setupMethod() {

        System.out.println("BeforeMethod works...");
        //driver = new BrowserService().getDriver();
    }

    @AfterMethod
    public void tearDownMethod() {

        System.out.println("AfterMethod works...");
        //driver.quit();
    }

    @AfterTest
    public void afterTest() {

        System.out.println("AfterTest works...");
    }

    @BeforeSuite
    public void beforeSuiteTest() {

        System.out.println("BeforeSuite works...");
    }

    @AfterSuite
    public void afterSuiteTest() {

        System.out.println("AfterSuite works...");
    }
}

package base;

import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;
    protected ReadProperties properties;

    @BeforeTest
    public void setupTest(){

        properties = new ReadProperties();
    }

    @BeforeClass
    public void setupMethod(){

        driver = new BrowserService().getDriver();
    }

    @AfterClass
    public void tearDownMethod(){

        driver.quit();
    }
}

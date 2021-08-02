package baseEntities;

import core.BrowserService;
import core.ReadProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import utils.Listener;

@Listeners(Listener.class)
public class BaseTest {

    public WebDriver driver;
    protected ReadProperties properties;

    @BeforeTest
    @Step("Setup test")
    public void setupTest(){

        properties = new ReadProperties();
    }

    @BeforeMethod
    @Step("Setup method")
    public void setupMethod(){

        driver = new BrowserService().getDriver();
    }

    @AfterMethod
    @Step("Teardown method")
    public void tearDownMethod(){

        driver.quit();
    }
}

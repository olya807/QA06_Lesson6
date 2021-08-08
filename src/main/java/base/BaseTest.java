package base;

import core.BrowserService;
import core.ReadProperties;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import utils.Listener;

@Listeners(Listener.class)
public class BaseTest {

    public BrowserService browserService;
    protected ReadProperties properties;

    @BeforeTest
    @Step("Setup test")
    public void setupTest(){

        properties = new ReadProperties();
    }

    @BeforeMethod
    @Step("Setup method")
    public void setupMethod(){

        browserService = new BrowserService();
    }

    @AfterMethod
    @Step("Teardown method")
    public void tearDownMethod(){

        browserService.getDriver().quit();
    }
}

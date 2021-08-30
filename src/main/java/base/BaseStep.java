package base;

import core.ReadProperties;
import org.openqa.selenium.WebDriver;

public class BaseStep {

    protected WebDriver driver;
    protected ReadProperties properties;

    public BaseStep(WebDriver driver){

        this.driver = driver;
        properties = new ReadProperties();
    }
}

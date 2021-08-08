package base;

import core.BrowserService;
import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected static final int WAIT_FOR_PAGE_LOADING_SEC = 15;
    protected WebDriver driver;
    protected BrowserService browserService;
    //public String baseUrl;
    protected ReadProperties properties;

    protected abstract void openPage();

    public abstract boolean isPageOpen();

    public BasePage(BrowserService browserService, boolean openPageByUrl) {
        this.browserService = browserService;
        this.driver = browserService.getDriver();
        //this.baseUrl = new ReadProperties().getUrl();
        properties = new ReadProperties();

        PageFactory.initElements(this.driver, this);

        if (openPageByUrl)
            openPage();

        waitForOpen();
    }

    protected void waitForOpen() {

        int secondsCount = 0;
        boolean isPageOpenIndicator = isPageOpen();

        while (!isPageOpenIndicator && secondsCount < WAIT_FOR_PAGE_LOADING_SEC) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            secondsCount++;
            isPageOpenIndicator = isPageOpen();
        }

        if (!isPageOpenIndicator)
            throw new AssertionError("Page wasn't opened.");
    }
}

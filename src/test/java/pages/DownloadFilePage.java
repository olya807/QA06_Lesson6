package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DownloadFilePage extends BasePage {

    private final static By pageTitle = By.tagName("h3");
    private final static String fileByName = "//a[contains(text(), 'fileName')]";

    public DownloadFilePage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {

        driver.get(properties.getBaseUrl() + "/download");
    }

    @Override
    public boolean isPageOpen() {

        try {
            return getTitleText().equals("File Downloader");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement getTitle() {

        return waits.waitForVisibility(pageTitle);
    }

    public String getTitleText() {

        return getTitle().getText();
    }

    public WebElement getFileByName(String fileName){

        return waits.waitForVisibility(
                By.xpath(fileByName.replace("fileName", fileName))
        );
    }

    public String getFileDownloadLink(String fileName){

        return getFileByName(fileName).getAttribute("href");
    }
}

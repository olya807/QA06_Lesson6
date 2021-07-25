package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploaderPage extends BasePage {

    private final static By pageTitle = By.tagName("h3");
    private final static By button_ChooseFile = By.id("file-upload");
    private final static By button_FileSubmit = By.id("file-submit");
    private final static By message_Uploaded = By.id("uploaded-files");

    public FileUploaderPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {

        driver.get(properties.getBaseUrl() + "/upload");
    }

    @Override
    public boolean isPageOpen() {

        try {
            return getTitleText().equals("File Uploader");
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

    public WebElement getChooseFile() {

        return waits.waitForVisibility(button_ChooseFile);
    }

    public WebElement getButtonUpload() {

        return waits.waitForVisibility(button_FileSubmit);
    }

    public WebElement getMessageUploaded() {
        return waits.waitForVisibility(message_Uploaded);
    }
}

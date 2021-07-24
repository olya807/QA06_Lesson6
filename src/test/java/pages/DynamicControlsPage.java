package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicControlsPage extends BasePage {

    private final static By pageTitle = By.tagName("h4");
    private final static By checkBox = By.cssSelector("input[type='checkbox']");
    private final static By button_Remove = By.cssSelector("[onclick='swapCheckbox()']");
    private final static By checkBox_Message = By.cssSelector("#checkbox-example #message");
    private final static By input = By.cssSelector("#input-example input");
    private final static By button_DisableOrEnableInput = By.cssSelector("[onclick='swapInput()']");
    private final static By input_Message = By.cssSelector("#input-example #message");

    public DynamicControlsPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {

        driver.get(properties.getBaseUrl() + "/dynamic_controls");
    }

    @Override
    public boolean isPageOpen() {

        try {
            return getTitleText().equals("Dynamic Controls");
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

    public WebElement getCheckBox() {

        return waits.waitForVisibility(checkBox);
    }

    public boolean isCheckBoxInvisible() {

        return waits.waitForInvisibility(checkBox);
    }

    public WebElement getButtonRemove() {

        return driver.findElement(button_Remove);
    }

    public WebElement getCheckBoxMessage() {

        return waits.waitForVisibility(checkBox_Message);
    }

    public WebElement getInput() {

        return driver.findElement(input);
    }

    public boolean isInputDisabled() {
        boolean isDisabled = false;

        try {
            if(getInput().getAttribute("disabled").equals("true"))
                isDisabled = true;

        } catch (NullPointerException ex) {
            return false;
        }

        return isDisabled;
    }

    public WebElement getButtonDisableOrEnable() {

        return driver.findElement(button_DisableOrEnableInput);
    }

    public WebElement getInputMessage() {

        return waits.waitForVisibility(input_Message);
    }
}

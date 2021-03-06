package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    private final static String endpoint = "inventory.html";
    private final static By title_Label_By = By.className("title");
    private final static String product_AddToCart_Button = "//div[.='text_to_replace']/ancestor::div[@class='inventory_item_description']//button";

    public ProductsPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getUrl() + endpoint);
    }

    @Override
    public boolean isPageOpen() {

        try {
            return getTitleLabel().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //Getters
    public WebElement getTitleLabel() {
        return driver.findElement(title_Label_By);
    }

    public String getTitleText() {
        return getTitleLabel().getText();
    }

    public WebElement getAddToCartButtonForProduct(String productName){

        return driver.findElement(By.xpath(product_AddToCart_Button.replace("text_to_replace", productName)));
    }

    public void addToCart(String productName){

        getAddToCartButtonForProduct(productName).click();
    }
}

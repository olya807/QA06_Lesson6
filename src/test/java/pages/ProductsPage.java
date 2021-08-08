package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {

    private final static String endpoint = "inventory.html";
    private final static By title_Label_By = By.className("title");
    private final static By shoppingCart_Link_By = By.className("shopping_cart_link");
    private final static By cart_Badge_By = By.className("shopping_cart_badge");
    private final static String product_AddOrRemoveFromCart_Button = "//div[.='text_to_replace']/ancestor::div[@class='inventory_item_description']//button";

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

    public WebElement getShoppingCartLink() {

        return driver.findElement(shoppingCart_Link_By);
    }

    public WebElement getCartBadge(){

        return driver.findElement(cart_Badge_By);
    }

    public String getCartBadgeText(){

        return getCartBadge().getText();
    }

    public WebElement getAddOrRemoveFromCartProductButton(String productName){

        return driver.findElement(By.xpath(product_AddOrRemoveFromCart_Button.replace("text_to_replace", productName)));
    }

    public void addOrRemoveFromCart(String productName){

        getAddOrRemoveFromCartProductButton(productName).click();
    }
}

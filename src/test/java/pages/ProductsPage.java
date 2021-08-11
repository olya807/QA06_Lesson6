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
    private final static String productAddToCart_Button_By = "//div[.='text_to_replace']/ancestor::div[@class='inventory_item_description']//button[.='Add to cart']";
    private final static String productRemoveFromCart_Button_By = "//div[.='text_to_replace']/ancestor::div[@class='inventory_item_description']//button[.='Remove']";

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

    public WebElement getAddToCartProductButton(String productName){

        return driver.findElement(By.xpath(productAddToCart_Button_By.replace("text_to_replace", productName)));
    }

    public void addToCart(String productName){

        getAddToCartProductButton(productName).click();
    }

    public WebElement getRemoveFromCartProductButton(String productName){

        return driver.findElement(By.xpath(productRemoveFromCart_Button_By.replace("text_to_replace", productName)));
    }

    public void removeFromCart(String productName){

        getRemoveFromCartProductButton(productName).click();
    }
}

package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    private final static String endpoint = "inventory.html";

    //PageFactory Selectors
    @CacheLookup
    @FindBy(className = "title")
    public WebElement title_Label_By;

    @CacheLookup
    @FindBy(className = "shopping_cart_link")
    public WebElement shoppingCart_Link_By;

    @CacheLookup
    @FindBy(className = "shopping_cart_badge")
    public WebElement cart_Badge_By;

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
            return title_Label_By.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //PageFactory atomic methods for work with elements

    public String getTitleText() {
        return title_Label_By.getText();
    }

    public String getCartBadgeText(){

        return cart_Badge_By.getText();
    }

    public WebElement getAddToCartProductButton(String productName){

        return driver.findElement(By.xpath(productAddToCart_Button_By.replace("text_to_replace", productName)));
    }

    public ProductsPage addToCart(String productName){

        getAddToCartProductButton(productName).click();

        return new ProductsPage(driver, false);
    }

    public WebElement getRemoveFromCartProductButton(String productName){

        return driver.findElement(By.xpath(productRemoveFromCart_Button_By.replace("text_to_replace", productName)));
    }

    public void removeFromCart(String productName){

        getRemoveFromCartProductButton(productName).click();
    }

    public ShoppingCartPage clickShoppingCartLink(){

        shoppingCart_Link_By.click();

        return new ShoppingCartPage(driver, false);
    }

    public ProductsPage addProducts(List<String> products) {

        for (String s : products) {
            addToCart(s);
        }

        return new ProductsPage(driver, false);
    }

    public ProductsPage removeProducts(List<String> products) {

        for (String s : products) {
            removeFromCart(s);
        }

        return new ProductsPage(driver, false);
    }

    public ShoppingCartPage addProductsAndGoToCart(List<String> products){

        addProducts(products);
        clickShoppingCartLink();

        return new ShoppingCartPage(driver, false);
    }
}

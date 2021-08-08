package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    private final static String endpoint = "cart.html";
    private final static By title_Label_By = By.className("title");
    private final static By cartItemLabel_By = By.className("cart_item_label");
    private final static By cart_Badge_By = By.className("shopping_cart_badge");
    private final static By checkout_Button_By = By.id("checkout");
    private final static String product_AddOrRemoveFromCart_Button = "//div[.='text_to_replace']/ancestor::div[@class='cart_item_label']//button";

    public ShoppingCartPage(WebDriver driver, boolean openPageByUrl) {
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

    public List<WebElement> getCartItemLabels() {
        return driver.findElements(cartItemLabel_By);
    }

    public WebElement getCartBadge(){

        return driver.findElement(cart_Badge_By);
    }

    public String getCartBadgeText(){

        return getCartBadge().getText();
    }

    public WebElement getCheckoutButton(){

        return driver.findElement(checkout_Button_By);
    }

    public WebElement getRemoveFromCartProductButton(String productName){

        return driver.findElement(By.xpath(product_AddOrRemoveFromCart_Button.replace("text_to_replace", productName)));
    }
}

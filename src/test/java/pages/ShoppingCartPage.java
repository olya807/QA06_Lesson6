package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    private final static String endpoint = "cart.html";

    //PageFactory Selectors
    @CacheLookup
    @FindBy(className = "title")
    public WebElement title_Label_By;

    @CacheLookup
    @FindBy(className = "cart_item_label")
    public List<WebElement> cartItemLabel_By;

    @CacheLookup
    @FindBy(className = "shopping_cart_badge")
    public WebElement cart_Badge_By;

    @CacheLookup
    @FindBy(id = "checkout")
    public WebElement checkout_Button_By;

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
            return title_Label_By.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //Getters

    public String getCartBadgeText(){

        return cart_Badge_By.getText();
    }

    public WebElement getRemoveFromCartProductButton(String productName){

        return driver.findElement(By.xpath(product_AddOrRemoveFromCart_Button.replace("text_to_replace", productName)));
    }

    public CheckoutPage clickCheckoutButton(){

        checkout_Button_By.click();

        return new CheckoutPage(driver, false);
    }

    public void removeProductFromCartByName(String productName){

        getRemoveFromCartProductButton(productName).click();
    }

    public ShoppingCartPage removeProducts(List<String> products) {

        for (String s : products) {
            removeProductFromCartByName(s);
        }

        return new ShoppingCartPage(driver, false);
    }
}

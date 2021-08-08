package steps;

import base.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

public class OrderStep extends BaseStep {

    public OrderStep(WebDriver driver) {
        super(driver);
    }

    public void orderOneProduct(String productName){

        ProductsPage productsPage = new ProductsPage(driver, true);
        productsPage.addOrRemoveFromCart(productName);
    }
}

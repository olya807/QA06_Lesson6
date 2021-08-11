package steps;

import base.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

import java.util.List;

public class ProductsSteps extends BaseStep {

    public ProductsSteps(WebDriver driver) {
        super(driver);
    }

    public void addProducts(List<String> products) {

        ProductsPage product = new ProductsPage(driver, false);

        for (String s : products) {
            product.addToCart(s);
        }
    }

    public void removeProducts(List<String> products) {

        ProductsPage product = new ProductsPage(driver, false);

        for (String s : products) {
            product.removeFromCart(s);
        }
    }

    public void addProductsAndGoToCart(List<String> products){

        ProductsPage product = new ProductsPage(driver, false);

        addProducts(products);
        product.getShoppingCartLink().click();
    }
}

package steps;

import base.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.ShoppingCartPage;

import java.util.List;

public class ShoppingCartSteps extends BaseStep {

    public ShoppingCartSteps(WebDriver driver) {
        super(driver);
    }

    public void removeProducts(List<String> products) {

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver, false);

        for (String s : products) {
            shoppingCartPage.removeProductFromCartByName(s);
        }
    }
}

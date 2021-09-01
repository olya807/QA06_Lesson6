package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import pages.ProductsPage;

import java.util.List;

public class ProductSteps extends BaseStep {
    public ProductSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public ProductSteps addItemToCart(String productName) {
        new ProductsPage(browsersService, false).getItemAddToCartButton(productName).click();
        return this;
    }

    public ProductSteps addItemsToCart(List<String> itemsList) {
        for (String item : itemsList) {
            addItemToCart(item);
        }
        return this;
    }

    public CheckoutSteps moveToCart() {
        new ProductsPage(browsersService, false).cartBadgeClick();
        return new CheckoutSteps(browsersService);
    }
}

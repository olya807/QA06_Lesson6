package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class Dropdown {

    private final WebDriver driver;
    private Map<String, WebElement> dropdownList = new HashMap<>();
    private Map<String, WebElement> dropdownMenuList = new HashMap<>();

    public Dropdown(WebDriver driver) {

        this.driver = driver;
        for (WebElement element: driver.findElements(By.cssSelector(".top-menu-item a"))) {
            dropdownList.put(element.getAttribute("innerText").trim(), element);
        }
    }

    public void clickDropDownByNameAndMenuValue(String dropdownName, String dropdownMenuValue) {

        dropdownList.get(dropdownName).click();

        String[] dropdownMenuId = dropdownList.get(dropdownName).getAttribute("href").split("#");

        for (WebElement element: driver.findElements(By.cssSelector(String.format("#%s a.dropdown-menu-link", dropdownMenuId[dropdownMenuId.length - 1])))) {
            dropdownMenuList.put(element.getText().trim(), element);
        }

        dropdownMenuList.get(dropdownMenuValue).click();
    }
}

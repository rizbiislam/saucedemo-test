package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;
    private By addToCartButton = By.cssSelector("button.btn.btn_primary.btn_small.btn_inventory");
    private By cartButton = By.className("shopping_cart_link");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addItemsToCart(int itemCount) {
        List<WebElement> addToCartButtons = driver.findElements(addToCartButton);
        for (int i = 0; i < itemCount && i < addToCartButtons.size(); i++) {
            addToCartButtons.get(i).click();
        }
    }

    public void goToCart() {
        driver.findElement(cartButton).click();
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
}

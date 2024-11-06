// HomePage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By menuButton = By.id("react-burger-menu-btn");
    private By resetButton = By.id("reset_sidebar_link");
    private By closeButton = By.className("bm-cross-button");
    private By allItemsButton = By.id("inventory_sidebar_link");
    private By addToCartButtons = By.cssSelector("button.btn.btn_primary.btn_small.btn_inventory");
    private By cartButton = By.className("shopping_cart_link");
    private By orderby = By.xpath("//div[@class = 'right_component']/span[@class = 'select_container']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void resetAppState() {
        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(resetButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();

    }
    public void sortedBy(String order) {

		wait.until(ExpectedConditions.elementToBeClickable(orderby)).click();
        if (order.equals("Z to A")) {
            driver.findElement(By.xpath("//option[@value='za']")).click();
        } else {
        
        	System.out.println("Doesn't Matched");
        }
		
	}


	public void addItemsToCart(int numberOfItems) {
		
        wait.until(ExpectedConditions.elementToBeClickable(allItemsButton)).click();
		List<WebElement> buttons = driver.findElements(addToCartButtons);
        for (int i = 0; i < numberOfItems && i < buttons.size(); i++) {
            buttons.get(i).click();
        }
		
	}
	
public void addSingleItemToCart(int itemNumber) {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        buttons.get(itemNumber).click();
        
		
	}
	

	public void openCart() {
		wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();
		
	}

}

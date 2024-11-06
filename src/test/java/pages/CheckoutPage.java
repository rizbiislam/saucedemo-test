// CheckoutPage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private By backAllProducts = By.xpath("//button[@id = 'back-to-products' and @name ='back-to-products']");
    private By checkoutButton = By.id("checkout");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By productNames = By.cssSelector(".inventory_item_name");
    private By productPrices = By.cssSelector(".inventory_item_price");
    private By totalPriceLabel = By.className("summary_total_label");
    private By subtotalLabel = By.xpath("//div[@class = 'summary_subtotal_label']");
    private By finishShoping = By.xpath("//button[@id = 'finish']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void startCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public void fillOutCheckoutInfo(String firstName, String lastName, String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField)).sendKeys(postalCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();
    }

    public double calculateTotalPrice() {
        List<WebElement> names = driver.findElements(productNames);
        List<WebElement> prices = driver.findElements(productPrices);

        System.out.println("Product Names and Prices:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println("Name: " + names.get(i).getText() + ", Price: " + prices.get(i).getText());
        }

        return prices.stream()
                     .mapToDouble(p -> Double.parseDouble(p.getText().replace("$", "")))
                     .sum();
    }


    public String getDisplayedTotalPrice() {
        return driver.findElement(totalPriceLabel).getText();
    }

    public String getItemSubtotal() {
        return driver.findElement(subtotalLabel).getText();
    }
    public void finishdShoping() {
    	wait.until(ExpectedConditions.elementToBeClickable(finishShoping)).click();
    }
    
    public void BackToAll() {
        wait.until(ExpectedConditions.elementToBeClickable(backAllProducts)).click();
    }
}

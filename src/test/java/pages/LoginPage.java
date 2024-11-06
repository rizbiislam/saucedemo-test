package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    private By usernameField = By.xpath("//input[@id='user-name']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@id='login-button']");
    private By errorMessage = By.xpath("//h3[@data-test='error']");
    

    private By menuButtons = By.id("react-burger-menu-btn");
    private By LogoutButton = By.id("logout_sidebar_link");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String username, String password) {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(usernameField)).sendKeys(username);
    	wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
    	
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        /*driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();*/
    }
    
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    
    public void Logout() {
        wait.until(ExpectedConditions.elementToBeClickable(menuButtons)).click();
        wait.until(ExpectedConditions.elementToBeClickable(LogoutButton)).click();

    }
}

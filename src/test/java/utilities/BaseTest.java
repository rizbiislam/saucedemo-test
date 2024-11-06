package utilities;

import io.qameta.allure.Step;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    protected Actions actions;

    @BeforeMethod
    public void setUp() {
    	//WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        actions = new Actions(driver);
        createAllureResultsDirectory();
        createScreenshotsDirectory();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Step("Capture screenshot")
    public void captureScreenshot(String methodName) {
        if (driver == null) {
            System.err.println("WebDriver is not initialized. Cannot capture screenshot.");
            return;
        }
        
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshots/" + methodName + ".png"));

            try (FileInputStream inputStream = new FileInputStream(screenshot)) {
                Allure.addAttachment(methodName, "image/png", inputStream, ".png");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createAllureResultsDirectory() {
        File directory = new File("allure-results");
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("Allure results directory created: " + directory.getAbsolutePath());
            } else {
                System.err.println("Failed to create Allure results directory.");
            }
        }
    }

    private void createScreenshotsDirectory() {
        File directory = new File("screenshots");
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (created) {
                System.out.println("Screenshots directory created: " + directory.getAbsolutePath());
            } else {
                System.err.println("Failed to create screenshots directory.");
            }
        }
    }
}

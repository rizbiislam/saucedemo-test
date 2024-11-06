package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.CheckoutPage;
import utilities.BaseTest;

public class QuestionThree extends BaseTest {
	
	

    @Test
    public void QuestionThree() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("performance_glitch_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        homePage.resetAppState();
        homePage.sortedBy("Z to A");
        homePage.addSingleItemToCart(2);
        homePage.openCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.startCheckout();
        checkoutPage.fillOutCheckoutInfo("John", "Doe", "12345");

        double calculatedTotal = checkoutPage.calculateTotalPrice();
        String displayedTotal = checkoutPage.getDisplayedTotalPrice();
        String itemSubtotal = checkoutPage.getItemSubtotal();

        Assert.assertTrue(itemSubtotal.contains(String.valueOf(calculatedTotal)), "Item's total price verified successfully.");
        System.out.println("Displayed Total Price: " + displayedTotal);
        System.out.println("Item Total Price: " + itemSubtotal);
    }

}

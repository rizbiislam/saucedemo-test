package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.CheckoutPage;
import utilities.BaseTest;

public class QuestionTwo extends BaseTest {

    @Test
    public void QuestionTwo() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        homePage.resetAppState();
        homePage.addItemsToCart(3);
        homePage.openCart();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.startCheckout();
        checkoutPage.fillOutCheckoutInfo("John", "Doe", "12345");

        double calculatedTotal = checkoutPage.calculateTotalPrice();
        String displayedTotal = checkoutPage.getDisplayedTotalPrice();
        String itemSubtotal = checkoutPage.getItemSubtotal();

        Assert.assertTrue(itemSubtotal.contains(String.valueOf(calculatedTotal)), "Item's total price verified successfully.");
        System.out.println("\n\nCalculated Total Price: " + calculatedTotal);
        System.out.println("Item Total Price: " + itemSubtotal);
        System.out.println("Displayed Total Price: " + displayedTotal);
        
        checkoutPage.finishdShoping();
        checkoutPage.BackToAll();
        homePage.resetAppState();
        loginPage.Logout();
    }
}

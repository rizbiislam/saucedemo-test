package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.BaseTest;

public class QuestionOne extends BaseTest {

	@Test
    public void QuestionTwo() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");
        String errors = loginPage.getErrorMessage();
        System.out.println(errors);
	}
}

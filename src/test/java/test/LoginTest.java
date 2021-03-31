package test;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.DatabasePage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest extends BrowserFactory {

	LoginPage login;

	@BeforeMethod
	public void setUp() {
		initializeDriver();
		login = PageFactory.initElements(driver, LoginPage.class);
	}

	@Test(priority = 1)
	public void validUserShouldAbleToLogin() throws ClassNotFoundException, SQLException, IOException {
		login.enterName("demo@techfios.com");
		login.enterPassword("abc123");
		login.clickSigninButton();
		login.takeScreenshotAtEndOfTest(driver);
		login.validateDashboardHeader();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}

package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import util.BrowserFactory;

public class LoginPage extends BrowserFactory {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement Username_Field;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement Password_Field;
	@FindBy(how = How.XPATH, using = "//button[@name='login']")
	WebElement Signin_Button;

	// Interactive Methods
	public void enterName(String userName) {
		Username_Field.sendKeys(userName);
	}

	public void enterPassword(String password) {
		Password_Field.sendKeys(password);
	}

	public void enterCredentials(String userName, String password) {
		Username_Field.sendKeys(userName);
		Password_Field.sendKeys(password);
	}

	public void clickSigninButton() {
		Signin_Button.click();
	}

	public void validateDashboardHeader() {

		Assert.assertEquals("Dashboard- iBilling", driver.getTitle());
	}

	public String getPageTittle() {
		return driver.getTitle();

	}
}
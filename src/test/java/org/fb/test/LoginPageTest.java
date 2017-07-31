package org.fb.test;

import org.fb.pages.HomePage;
import org.fb.pages.LoginPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.utility.Base;

public class LoginPageTest extends Base {
	static WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	Base base = new Base();

	@BeforeClass
	public static void launchBrowser() {
		driver = getDriver();

	}

	@Test
	public void verifyLoginDetails() {

		loginPage = new LoginPage();
		homePage = new HomePage();
		Assert.assertTrue(elementFound(driver, 10, loginPage.getImgFbLogo()));
		getScreenShot("facebookPage");

		setText(loginPage.getTxtUserName(), "ramesh@gmail.com");
		getScreenShot("username");
		Assert.assertEquals("ramesh@gmail.com",
				getText(loginPage.getTxtUserName()));
		getScreenShot("password");
		loginPage.setTxtPassword("12345");
		setText(loginPage.getTxtPassword(), "12345");
		getScreenShot("login");
		Assert.assertEquals("12345", getText(loginPage.getTxtPassword()));
		clickBtn(loginPage.getBtnLogin());
		getScreenShot("after login");
		System.out.println("Success");

	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();

	}

}

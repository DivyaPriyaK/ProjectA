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

		setText(loginPage.getTxtUserName(), readValueFromExcelSheet().get(1)
				.get("UserName"));
		getScreenShot("username");

		Assert.assertEquals(readValueFromExcelSheet().get(1).get("UserName"),
				getText(loginPage.getTxtUserName()));

		getScreenShot("password");
		setText(loginPage.getTxtPassword(), readValueFromExcelSheet().get(1)
				.get("Password"));
		getScreenShot("login");
		Assert.assertEquals(readValueFromExcelSheet().get(1).get("Password"),
				getText(loginPage.getTxtPassword()));
		clickBtn(loginPage.getBtnLogin());
		getScreenShot("after login");
		System.out.println("Success");

	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();

	}

}

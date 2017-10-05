package org.fb.test;

import org.fb.pages.HomePage;
import org.fb.pages.LoginPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.utility.Base;
import org.utility.JUnitTestReporter;
import org.utility.JUnitTestReporter;

public class LoginPageTest extends JUnitTestReporter {
	static WebDriver ldriver;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeClass
	public static void launchBrowser() {

		ldriver = Base.getDriver();

	}

	@Test
	public void verifyLoginDetails() {

		loginPage = new LoginPage();
		homePage = new HomePage();
		Assert.assertTrue(Base.elementFound(ldriver, 10,
				loginPage.getImgFbLogo()));
		Base.getScreenShot("facebookPage");

		Base.setText(loginPage.getTxtUserName(), Base.readValueFromExcelSheet()
				.get(1).get("UserName"));
		Base.getScreenShot("username");

		Assert.assertEquals(
				Base.readValueFromExcelSheet().get(1).get("UserName"),
				Base.getText(loginPage.getTxtUserName()));

		Base.getScreenShot("password");
		Base.setText(loginPage.getTxtPassword(), Base.readValueFromExcelSheet()
				.get(1).get("Password"));
		Base.getScreenShot("login");
		Assert.assertEquals(
				Base.readValueFromExcelSheet().get(1).get("Password"),
				Base.getText(loginPage.getTxtPassword()));
		Base.clickBtn(loginPage.getBtnLogin());
		Base.getScreenShot("after login");
		System.out.println("Success");

	}

	@AfterClass
	public static void closeBrowser() {
		ldriver.quit();

	}

}

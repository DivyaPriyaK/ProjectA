package org.demo.test;

import java.io.File;

import org.demo.pages.RegisterPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.utility.Base;

public class RegisterTest extends Base {
	static WebDriver driver;
	RegisterPage page;

	@BeforeClass
	public static void launchBrowser() {
		driver = Base.getDriver();

	}

	@Test
	public void registerDetails() {
		page = new RegisterPage();
		clickBtn(page.getBtnBrowse());
		uploadFiles(new File("./Files/Core java material.pdf"));

	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();

	}

}

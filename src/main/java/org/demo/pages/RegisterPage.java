package org.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.Base;

public class RegisterPage extends Base {
	@FindBy(id = "imagesrc")
	private WebElement btnBrowse;

	public WebElement getBtnBrowse() {
		return btnBrowse;
	}

	public RegisterPage() {
		PageFactory.initElements(Base.driver, this);

	}

	
}

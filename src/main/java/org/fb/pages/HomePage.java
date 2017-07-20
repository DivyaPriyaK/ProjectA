package org.fb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.Base;

public class HomePage extends Base {
	@FindBy(xpath = "//*[text()='Home']")
	private WebElement imgHomePageLogo;

	public HomePage() {
		PageFactory.initElements(Base.driver, this);
	}

	public WebElement getImgHomePageLogo() {
		return imgHomePageLogo;
	}

	public void setImgHomePageLogo(WebElement imgHomePageLogo) {
		this.imgHomePageLogo = imgHomePageLogo;
	}
}

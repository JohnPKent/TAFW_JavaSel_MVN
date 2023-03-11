package com.simplytesting.jsfw.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.simplytesting.jsfw.base.TestRun;


public class CookieBox extends TestRun {

	@FindBy(id = "onetrust-reject-all-handler")
	WebElement rejectAllButton;

	//////////////////////////////////////////////
	//Constructor - initialise elements
	//////////////////////////////////////////////
	public CookieBox() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickRejectAll() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestRun.uiWrappers.click(rejectAllButton);
	}

}

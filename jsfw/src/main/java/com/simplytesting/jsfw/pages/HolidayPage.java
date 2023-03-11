package com.simplytesting.jsfw.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.simplytesting.jsfw.base.TestRun;

public class HolidayPage extends TestRun{
	@FindBy(id = "dates_and_prices_title")
	WebElement datesAndPricesTitle;

	@FindBy(xpath = "//a[@id='supplier-phone']")
	WebElement phoneNumber;

	@FindBy(xpath = "//div[@id='price-pin_pin-wrapper']//span[contains(@id, 'days-num')]")
	WebElement pricePinNumberOfDays;

	@FindBy(xpath = "//div[@id='price-pin_pin-wrapper']//span[@class='ibecurr']")
	WebElement pricePinPrice;

	//////////////////////////////////////////////
	//Constructor - initialise elements
	//////////////////////////////////////////////
	public HolidayPage() {
		PageFactory.initElements(driver, this);
	}
	
	//////////////////////////////////////////////
	//Actions
	//////////////////////////////////////////////
	public String getHolidayPageTitle(){
		return driver.getTitle().trim();
	}

	public String getPhoneNumber() {
		return TestRun.uiWrappers.getText(phoneNumber).trim();
	}

	public String getPricePinNumberOfDays() {
		return TestRun.uiWrappers.getText(pricePinNumberOfDays).trim();
	}

	public String getPricePinPrice() {
		return TestRun.uiWrappers.getText(pricePinPrice).trim();
	}

	public String getPricePinValue(){
		return TestRun.uiWrappers.getAttriubute(pricePinPrice, "data-amt");
	}

}

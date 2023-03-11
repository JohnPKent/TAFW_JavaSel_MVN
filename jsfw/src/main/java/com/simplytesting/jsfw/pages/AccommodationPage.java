package com.simplytesting.jsfw.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.simplytesting.jsfw.base.TestRun;

public class AccommodationPage extends TestRun{
	@FindBy(xpath = "//select[@data-roomtype='Twin']")
	WebElement selectRoomTwin;

	@FindBy(xpath = "//select[contains(@data-roomtype, 'Double')]")
	WebElement selectRoomDouble;

	@FindBy(xpath = "//select[contains(@data-roomtype, 'sole occupancy')]")
	WebElement selectRoomDoubleSoleOccupancy;

	@FindBy(xpath = "//div[contains(text(),'Select your room')][contains(text(),'and continue')]/../..")
	WebElement continueButton;

	@FindBy(xpath = "//span[text()=' extra']/span")
	WebElement doubleSuppliment;

	

	//////////////////////////////////////////////
	//Constructor - initialise elements
	//////////////////////////////////////////////
	public AccommodationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getAccommodationPageTitle(){
		return driver.getTitle().trim();
	}

	public void selectTwinRoomType(String number){
		TestRun.uiWrappers.listSelectUsingText(selectRoomTwin, number);
	}

	public void selectDoubleRoomType(String number){
		TestRun.uiWrappers.listSelectUsingText(selectRoomDouble, number);
	}

	public String getDoubleSupplement(){
		return TestRun.uiWrappers.getAttriubute(doubleSuppliment, "data-amt");
	}

	public void clickContinue(){
		TestRun.uiWrappers.click(continueButton);
	}

}

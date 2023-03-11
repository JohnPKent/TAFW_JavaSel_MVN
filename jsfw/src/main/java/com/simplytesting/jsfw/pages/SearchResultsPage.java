package com.simplytesting.jsfw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.simplytesting.jsfw.base.TestRun;

public class SearchResultsPage extends TestRun{
	
		//////////////////////////////////////////////
		//Constructor - initialise elements
		//////////////////////////////////////////////
		public SearchResultsPage() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle(){
			return driver.getTitle().trim();
		}
		
		public HolidayPage clickResultItemContains(String resultItemText) {
			String xpathLocator = "//span[contains(text(),'"+ resultItemText + "')]/../..";
			WebElement element = driver.findElement(By.xpath(xpathLocator));
			TestRun.uiWrappers.click(element);
			return new HolidayPage();
		}
		
		public HolidayPage clickMoreInfoBTNForItemContains(String resultItemText) {
			String xpathLocator = "//span[contains(text(),'"+ resultItemText + "')]/../..//button";
			WebElement element = driver.findElement(By.xpath(xpathLocator));
			TestRun.uiWrappers.click(element);
			return new HolidayPage();
		}
}

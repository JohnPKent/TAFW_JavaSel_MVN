package jsfw.src.main.java.uiwrappers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.simplytesting.jsfw.base.TestRun;

public class UIWrappers {
	private WebDriver driver;

	public UIWrappers(WebDriver driver) {
		this.driver = driver;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//UI Object Wrappers put here due to time constraints
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void click(WebElement element)	{
		String selectorName = element.toString();
		String msg = " Clicking element '" + selectorName + "'";
		System.out.println(msg);
		
		try	{
			if (pageSynchronisation().equals("ERROR")) {
				System.out.println("WARNING: Page Sync issues.  Attempting to continue");
			}
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement elementObj = wait.until(ExpectedConditions.elementToBeClickable(element));
			elementObj.click();
		}catch (Exception e)	{
			msg = "Resut=FAIL: Exception: " + e.getMessage();
			System.out.println(msg);
			Assert.fail(msg);
			
		}
		System.out.println("Resut=PASS: clicked object");
		
	}

	public void enterText(WebElement element, String text)	{
		String selectorName = element.toString();
		String msg = "Entering Text: '" + text + "' into element '" + selectorName + "'";
		System.out.println(msg);
		
		try	{
			if ( pageSynchronisation().equals("ERROR")) {
				System.out.println("WARNING: Page Sync issues.  Attempting to continue");
			}
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement elementObj = wait.until(ExpectedConditions.elementToBeClickable(element));
			elementObj.clear();
			elementObj.sendKeys(text);
		}catch (Exception e)	{
			msg = "Resut=FAIL: Exception: " + e.getMessage();
			System.out.println( msg);
			Assert.fail(msg);
			
		}
		System.out.println("Resut=PASS: entered text");
		
	}

	public String getText(WebElement element)	{
		String selectorName = element.toString();
		String textFound = "";
		String msg = "Get Text from: element '" + selectorName + "'";
		System.out.println( msg);
		
		try	{
			if (pageSynchronisation().equals("ERROR")) {
				System.out.println("WARNING: Page Sync issues.  Attempting to continue");
			}
			textFound = element.getText();
		}catch (Exception e)	{
			msg = "Resut=FAIL: Exception: " + e.getMessage();
			System.out.println(msg);
			Assert.fail(msg);
			
		}
		System.out.println("Resut=PASS: text found: '" + textFound + "'");
		return textFound;
	}
	
	public boolean elementExists(WebElement element)	{
		String selectorName = element.toString();
		String msg = " Checking element '" + selectorName + "' exists";
		System.out.println(msg);
		
		try	{
			if (pageSynchronisation().equals("ERROR")) {
				System.out.println("WARNING: Page Sync issues.  Attempting to continue");
			}
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			element.isDisplayed();
			driver.manage().timeouts().implicitlyWait(TestRun.IMPLICIT_WAIT, TimeUnit.SECONDS);
		}catch (Exception e)	{
			msg = "Resut=PASS: element does not exist " ;
			System.out.println(msg);
			return false;
		}
		System.out.println("Resut=PASS: element does exist");
		return true;
		
	}

	public void listSelectUsingText(WebElement element, String textToSelect)
	{ 
	    WebElement selectedOption = null;
	    String selectedOptionText = "";
	    String sDataLower = textToSelect.toLowerCase();
	    Boolean bFoundOption =false;
	    List<WebElement>options = null;
		String selectorName = element.toString();
		String msg = "Selecting Text: '" + textToSelect + "' in list element '" + selectorName + "'";
		System.out.println(msg);

		try
	    {
		    options = element.findElements(By.tagName("option"));
	        System.out.println("Number of items (options) found = '" + options.size() + "'");
	        for (WebElement optionElement : options) {
	            if (optionElement.getText().toLowerCase().equals(sDataLower))
	            {
	                System.out.println("Item found with matching text.  Clicking...");
	                optionElement.click();
	                bFoundOption = true;
	                break;
	            }
	        }
	    }
	    catch(Exception e)
	    {
	        System.out.println("FAILURE: during getting options or during click.  Exception: '" + e.getMessage() + "'");
            Assert.fail();
	    }
	    if (!bFoundOption)    {
	        //Not Found so the text may be in the label attribute (as in select _ngcontent-c6):
	       for (WebElement optionElement : options) {
	            String sLabel = optionElement.getAttribute("label"); 
	            if (sLabel.toLowerCase().equals(sDataLower))
	            {
	                System.out.println("Item found with matching label.  Clicking...");
	                optionElement.click();
	                bFoundOption = true;
	                break;
	            }
	        }
	        if (!bFoundOption)    {
				System.out.println("FAILURE: option not found: '" + textToSelect + "'");
	            Assert.fail();
	        }
	    }
	
	    //Check Text Selected
	    try
	        {
	        options = element.findElements(By.tagName("option"));  // read again to eleminate stale element failure
	
	        for (WebElement optionElement : options) {
	            if (optionElement.isSelected()) {
	                selectedOption = optionElement;
	                selectedOptionText = selectedOption.getText();
	                break;
	            }
	        }
	        if (selectedOptionText.toLowerCase().trim().equals(sDataLower))
	        {
				System.out.println("Success: SET to: "  + textToSelect);
			}
		    else if((selectedOption != null) && (selectedOption.getAttribute("label").toLowerCase().trim().contains(sDataLower)))
	        {
				System.out.println("Success: SET to: "  + textToSelect);
	        }
	        else
	        {
	            System.out.println("WARNING Set text to '" + textToSelect + "' but is now '" + selectedOptionText + "'");
	        }
	    }catch(Exception e)
	    {
	        System.out.println("WARNING unable to check selected value.   Exception: '" + e.getMessage() + "'" );
	    }
	}

    public String getAttriubute(WebElement element, String attributeName)
    {
    	String attributeValue = null;
		String selectorName = element.toString();
		String msg = "Geting attribute: '" + attributeName + "' value from element '" + selectorName + "'";
		System.out.println(msg);
        try
        { 
        	attributeValue= element.getAttribute(attributeName); 
        }
        catch(Exception e)
        {
			msg = "Resut=FAIL: Exception: " + e.getMessage();
			System.out.println(msg);
			Assert.fail(msg);
        }

        System.out.println( "Attribute '"+ attributeName + "' is '" + attributeValue + "'");
        
        return attributeValue;	
    }
    
	public void scrollToElement(WebElement element) {
		String selectorName = element.toString();
		String msg = "Scrolling to element '" + selectorName + "'";
		System.out.println(msg);
 		try	{
		    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoViewIfNeeded()", element);
		}catch (Exception e)	{
			msg = "Resut=FAIL: Exception: " + e.getMessage();
			System.out.println(msg);
		}
			waitMilliSecs(2000);
	}
	
	public void waitMilliSecs(int i) {
		try	{
		    Thread.sleep(i);
		}catch (Exception e)	{
			System.out.println(e.getMessage());
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Synchronisation
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String pageSynchronisation() throws InterruptedException	 {
        //=====================================================
        //Check Page readyState
        //=====================================================
        int i;
        long iFramesCount = 0;
        String javascriptCode;
        String pageTitle = null;
        String pageReadyState = "";

        JavascriptExecutor jsEx = ((JavascriptExecutor)driver); 

        //=====================================================
        //Page readyState
        //=====================================================
        for (i = 1; i < 10; i++)
        {
            try
            {
                pageReadyState = (String)jsEx.executeScript("return document.readyState");
            }
            catch (Exception exp)
            {
                System.out.println("Problem with JavaScript getting document.readyState.  Error=" + exp.getMessage());
	            return ("ERROR");
            }
            System.out.println("Readystate of page=" + pageReadyState);
            //sReadyState will be null if ExecuteScript fails first time (can have error: System.InvalidOperationException: Session not started or terminated)
            if ((pageReadyState != null) && (pageReadyState.equals("complete")))
            {
                break;
            }
			Thread.sleep(2000);
        }
        if ((pageReadyState != null) && !(pageReadyState.equals("complete")))
        {
            System.out.println("FAILURE: Page ReadyState did not reach 'complete");
            return ("ERROR");
        }

        //=====================================================
        //Get Page Title
        //=====================================================
        try
        {
        	pageTitle = (String)jsEx.executeScript("return document.title");
        }
        catch (Exception exp)
        {
            System.out.println("Problem with executing JavaScript to get doc title.  Error=" + exp.getMessage());
        }
        System.out.println("Title of page=" + pageTitle);

        //===========================================================================================================================
        //Check All Frames readyState
        //===========================================================================================================================
        try
        {
	        javascriptCode = "return(top.frames.length)";
	        iFramesCount = (long)jsEx.executeScript(javascriptCode);
            System.out.println("Number of IFrames=" + Long.toString(iFramesCount));
        }
        catch (Exception exp)
        {
            System.out.println("WARNING on getting frame count: " + exp.toString());
        } 

        try
        {
            for ( i= 0; i<iFramesCount; i++)
            {
                pageTitle = "";
                pageReadyState = "";
                // switch to every frame
                driver.switchTo().frame(i);
                javascriptCode = "return (document.title)";
                pageTitle = (String)jsEx.executeScript(javascriptCode);
                javascriptCode = "document.readyState";
                pageReadyState = (String)jsEx.executeScript(javascriptCode);
                System.out.println("iFrame Title=" + pageTitle);
                System.out.println("iFrame ReadyState=" + pageReadyState);
                driver.switchTo().defaultContent();
            }
        }
        catch (Exception ex)
        {
            pageTitle = "Unknown";
            System.out.println("WARNING on getting frame readyState: " + ex.toString());
        }
        //Switch Back to main page
        driver.switchTo().defaultContent();

        //===========================================================================================================================
        //Wait for JQuery.active == 0
        //===========================================================================================================================
        if(IsAJaxLoading() )
        {
            System.out.println("JQuery is active after all iterations" );
        }
        return (" ");
    }
	private boolean IsAJaxLoading() throws InterruptedException
	{
        int i;
        long jQueryActive;
        boolean isJQueryPresent = false;
        boolean isAjaxLoading = false;
        JavascriptExecutor jsEx = ((JavascriptExecutor)driver); 

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		try
        {
            isJQueryPresent = (boolean)jsEx.executeScript("return !!window.jQuery");
        }
        catch(Exception e)
        {
	        System.out.println("WARNING: Exception on JavaScript: 'return !!window.jQuery'.  Exception = " + e.getMessage());
        }
        if (isJQueryPresent)
        { 
            for (i = 1; i < 50; i++)
            {
                try
                {
//                    jQueryActive = (int)jsEx.executeScript("return jQuery.active");
                    jQueryActive = (long) jsEx.executeScript("return jQuery.active");
                }
                catch (Exception e)
                {
                    System.out.println("Problem with JavaScript getting jQuery.active.  Problem=" + e.getMessage());
                    jQueryActive = 0;
                }
			    if (jQueryActive ==0)
			    {
	                System.out.println("JQuery.active==0");
	                isAjaxLoading = false;
                    break;
			    }else
			    {
	                System.out.println("JQuery.active=" + Long.toString(jQueryActive));
	                isAjaxLoading = true;
			    }
			    Thread.sleep(100);
            }
            System.out.println("JQuery active complete at iteration =" + Integer.toString(i));
        }else
        {
        	isAjaxLoading = false;
        }
	    driver.manage().timeouts().implicitlyWait(TestRun.IMPLICIT_WAIT, TimeUnit.SECONDS);
        return(isAjaxLoading);
	} 

}

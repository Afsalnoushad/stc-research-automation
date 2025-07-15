package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.utils.*;
import stthomas.stc_research_automation.base.BaseClass;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResearchEthics extends BaseClass{
	
	 
	@Test(priority = 1, description = "Navigate to Research Ethics and verify title/url", groups = {"smoke","regression"})
	public void navigateToResearchEthics() {
		
		SoftAssert softassert = new SoftAssert();
		
		By ResearchEthicsLocator = By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li[9]/a[1]/span[1]");
		WebElement ResearchEthicsScroll = driver.findElement(ResearchEthicsLocator);
		act.scrollToElement(ResearchEthicsScroll).perform();
		
		WebElement ResearchEthics = wait.waitForElementToBeClickable(ResearchEthicsLocator, 10);
	    act.moveToElement(ResearchEthics).click().perform();
	    
	    String researchEthicsTitle = driver.getTitle();
	    if (!researchEthicsTitle.equals("Research Ethics - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "Research_Ethics_Title_Mismatch");
	    }
	    softassert.assertEquals(researchEthicsTitle, "Research Ethics - St Thomas College (Autonomous)", "Research Ethics - Page title mismatch");
	    String researchEthicsUrl = driver.getCurrentUrl();
	    if (!researchEthicsUrl.contains("research-ethics")) {
	        ScreenshotUtils.takeScreenShot(driver, "Research_Ethics_URL_Mismatch");
	    }
	    softassert.assertTrue(researchEthicsUrl.contains("research-ethics"), "Did not navigate to Research Ethics");
	    softassert.assertAll();
	    
	}

	@Test(priority = 2, description = "Scroll, Open, Validate PDF and Scroll Top", groups = {"regression"})
	public void scrollAndValidateResearchEthicsPDF() {
	    WebElement scrollBottom = driver.findElement(By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/a[1]"));
	    act.scrollToElement(scrollBottom).perform();
	    SleepUtils.shortWait();

	    String mainWindow = driver.getWindowHandle();
	    scrollBottom.click();
	    Set<String> allWindow = driver.getWindowHandles();
	    for (String windowHandle : allWindow) {
	        if (!windowHandle.equals(mainWindow)) {
	            driver.switchTo().window(windowHandle);
	            String url = driver.getCurrentUrl();
	            if (url.endsWith(".pdf")) {
	            	SleepUtils.mediumWait();
	                System.out.println("Pdf opened in research ethics page with url : " + url);
	                driver.close();
	            }
	        }
	    }
	    driver.switchTo().window(mainWindow);
	    js.executeScript("window.scrollTo(0,0)");
	}



}

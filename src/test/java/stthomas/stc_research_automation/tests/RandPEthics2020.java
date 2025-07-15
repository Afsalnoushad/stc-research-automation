package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.base.BaseClass;
import stthomas.stc_research_automation.utils.*;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RandPEthics2020 extends BaseClass{
	
	@Test(priority = 1, description = "Navigate to Research and Publication Ethics 2020 section and verify title/url", groups = {"smoke","regression"})
	public void verifyEthics2020Navigation() {
	    SoftAssert softassert = new SoftAssert();

	    By linkLocator = By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li[11]/a[1]/span[1]");
        
	    WebElement RRAndPEthics2020Scroll = driver.findElement(linkLocator);
        act.scrollToElement(RRAndPEthics2020Scroll).perform();
        
	    WebElement RAndPEthics2020 = wait.waitForElementToBeClickable(linkLocator, 10);

	    act.moveToElement(RAndPEthics2020).click().perform();
	    js.executeScript("window.scrollBy(0,400)");

	    By headingLocator = By.xpath("//h2[contains(text(),'Research and Publication Ethics course')]");
	    wait.waitForElementToBeVisible(headingLocator, 10);

	    String ethics2020Title = driver.getTitle();
	    if (!ethics2020Title.equals("Research and Publication Ethics 2020 - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "Ethics2020_Title_Mismatch");
	    }
	    softassert.assertEquals(ethics2020Title, "Research and Publication Ethics 2020 - St Thomas College (Autonomous)", "Ethics 2020 - Page title mismatch");

	    String ethics2020Url = driver.getCurrentUrl();
	    if (!ethics2020Url.contains("research-and-publication-ethics-course2020")) {
	        ScreenshotUtils.takeScreenShot(driver, "Ethics2020_URL_Mismatch");
	    }
	    softassert.assertTrue(ethics2020Url.contains("research-and-publication-ethics-course2020"), "Did not navigate to Ethics 2020 section");

	    softassert.assertAll();
	}

	
	@Test(priority = 2, description = "Play and pause embedded video in Ethics 2020 section", groups = {"regression"})
	public void verifyEthics2020VideoPlayback() {
	    WebElement video = driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[2]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]/iframe[1]"));
	    act.moveToElement(video).click().perform();
	    SleepUtils.lengthyWait();
	    act.moveToElement(video).click().perform();
	    SleepUtils.shortWait();
	}
	
	@Test(priority = 3, description = "Click and verify all important links under Ethics 2020", groups = {"regression"})
	public void verifyEthics2020Links() {
	    String[] texts = {
	        "https://www.ugc.ac.in/pdfnews/9836633_Research-and",
	        "https://www.mgu.ac.in/uploads/2020/03/rpe.pdf",
	        "Exemption order of MG University",
	        "University of Calicut order regarding Course at St",
	        "https://stthomasforms.linways.com/onlineapplicatio"
	    };

	    for (String linkLoop : texts) {
	    	
	    	By linkLocator = By.xpath("//a[contains(text(),'" + linkLoop + "')]");
	    	
	    	WebElement linkScroll = driver.findElement(linkLocator);
	        act.scrollToElement(linkScroll).perform();	    	
	    	
	        WebElement link = wait.waitForElementToBeClickable(linkLocator, 10);
	        act.moveToElement(link).click().perform();
	        SleepUtils.mediumWait();
	        driver.navigate().back();
	        wait.waitForTitleIs("Research and Publication Ethics 2020 - St Thomas College (Autonomous)", 10);
	    }
	}
	
	@Test(priority = 4, description = "Switch to window and verify RPE form link", groups = {"regression"})
	public void verifyEthics2020WindowSwitchLink() {
		
	    String mainWindow = driver.getWindowHandle();
	    
        By linkLocator = By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/p[9]/a[1]");
        WebElement linkScroll = driver.findElement(linkLocator);
        act.scrollToElement(linkScroll).perform();
        
	    WebElement link = wait.waitForElementToBeClickable(linkLocator, 10);
	    act.moveToElement(link).click().perform();

	    Set<String> allWindow = driver.getWindowHandles();
	    String title = "";
	    for (String windowHandle : allWindow) {
	        if (!windowHandle.equals(mainWindow)) {
	            driver.switchTo().window(windowHandle);
	            title = driver.getTitle();
	        }
	        if (title.equals("Research and publication ethics (RPE)")) {
	            driver.switchTo().window(windowHandle);
	            SleepUtils.mediumWait();
	            driver.close();
	        }
	    }

	    driver.switchTo().window(mainWindow);
	}
	
	@Test(priority = 5, description = "Verify UGC Guidelines and final links", groups = {"regression"})
	public void verifyEthics2020FinalDocuments() {
	    String[] linkRedirect = {
	    		"//a[contains(text(),'click here for UGC Guidelines')]",
	    		"//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[8]/div[2]/b[1]/a[1]"
		    };

		for (String xpath : linkRedirect) {
			
			    	
			By Linklocator = By.xpath(xpath);
		
			WebElement elementToScroll = driver.findElement(Linklocator);
			act.scrollToElement(elementToScroll).perform();
		
			WebElement link = wait.waitForElementToBeClickable(Linklocator, 10);
	        act.moveToElement(link).click().perform();

	        SleepUtils.mediumWait();
	        
	        driver.navigate().back();

	        wait.waitForTitleIs("Research and Publication Ethics 2020 - St Thomas College (Autonomous)", 10);
	    }
			    
	   js.executeScript("window.scrollTo(0,600)");
		
	}



}

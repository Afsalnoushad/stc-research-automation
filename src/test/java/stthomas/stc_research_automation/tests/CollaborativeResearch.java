package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.base.BaseClass;
import stthomas.stc_research_automation.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CollaborativeResearch extends BaseClass{
	
	@Test(priority = 1, description = "Navigate to Collaborative Research Section and verify title/url", groups = {"smoke","regression"})
	public void navigateToCollaborativeResearch() {
		
	    SoftAssert softassert = new SoftAssert();

	    By collaborativeResearchLocator = By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li[13]/a[1]/span[1]");
	    
	    WebElement collaborativeResearchScroll = driver.findElement(collaborativeResearchLocator);
	    act.scrollToElement(collaborativeResearchScroll).perform();

	    WebElement collaborativeResearch = wait.waitForElementToBeClickable(collaborativeResearchLocator, 10);
	    act.moveToElement(collaborativeResearch).click().perform();

	    SleepUtils.shortWait();

	    String title = driver.getTitle();
	    if (!title.equals("Collaborative Research - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "Collaborative_Research_Title_Mismatch");
	    }
	    softassert.assertEquals(title, "Collaborative Research - St Thomas College (Autonomous)", "Collaborative Research - Page title mismatch");

	    String url = driver.getCurrentUrl();
	    if (!url.contains("collaborative-research")) {
	        ScreenshotUtils.takeScreenShot(driver, "Collaborative_Research_URL_Mismatch");
	    }
	    softassert.assertTrue(url.contains("collaborative-research"), "Did not navigate to Collaborative Research page");
	    softassert.assertAll();
	}

	
	@Test(priority = 2, description = "Verify all links in Collaborative Research", groups = {"regression"})
	public void verifyCollaborativeResearchLinks() {
		SoftAssert softassert=new SoftAssert();
		String[] xpathsForLinks = {
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[1]/div[1]/div[2]/div[1]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[1]/div[1]/div[2]/div[1]/p[1]/span[1]/span[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[1]/div[1]/div[2]/div[1]/p[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[1]/div[1]/div[2]/div[1]/p[1]/a[2]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[1]/div[1]/div[2]/div[2]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[1]/div[1]/div[2]/div[2]/div[2]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[2]/div[1]/div[2]/div[1]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[2]/div[1]/div[2]/div[1]/p[1]/span[1]/span[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[2]/div[1]/div[2]/div[1]/p[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[2]/div[1]/div[2]/div[1]/p[1]/a[2]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[2]/div[1]/div[2]/div[2]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[2]/div[1]/div[2]/div[2]/div[2]/a[1]/i[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[4]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[4]/div[1]/div[2]/div[1]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[4]/div[1]/div[2]/div[1]/p[1]/span[1]/span[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[4]/div[1]/div[2]/div[1]/p[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[4]/div[1]/div[2]/div[1]/p[1]/a[2]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[4]/div[1]/div[2]/div[2]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[4]/div[1]/div[2]/div[2]/div[2]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[3]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[3]/div[1]/div[2]/div[1]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[3]/div[1]/div[2]/div[1]/p[1]/span[1]/span[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[3]/div[1]/div[2]/div[1]/p[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[3]/div[1]/div[2]/div[2]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[3]/div[1]/div[2]/div[2]/div[2]/a[1]/i[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[6]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[6]/div[1]/div[2]/div[1]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[6]/div[1]/div[2]/div[1]/p[1]/span[1]/span[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[6]/div[1]/div[2]/div[1]/p[1]/a[1]",
				  "//a[contains(text(),'Finishing School-Activities')]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[6]/div[1]/div[2]/div[2]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[6]/div[1]/div[2]/div[2]/div[2]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[5]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[5]/div[1]/div[2]/div[1]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[5]/div[1]/div[2]/div[1]/p[1]/span[1]/span[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[5]/div[1]/div[2]/div[1]/p[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[5]/div[1]/div[2]/div[1]/p[1]/a[2]",
				  "//a[contains(text(),'English-workshop')]",
				  "//a[contains(text(),'IQAC-workshop')]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[5]/div[1]/div[2]/div[2]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[5]/div[1]/div[2]/div[2]/div[2]/a[1]"
				  
		  };
	    
	    for (String linkClickAction : xpathsForLinks) {
	    	
	    	By linkLocator = By.xpath(linkClickAction);

	    	WebElement linkScroll = driver.findElement(linkLocator);
	    	act.scrollToElement(linkScroll).perform();
	    	act.moveToElement(linkScroll).perform();

	    	WebElement link = wait.waitForElementToBeVisible(linkLocator, 10);
	    	softassert.assertTrue(link.isDisplayed(), "Link not displayed: " + linkClickAction);
	    	act.moveToElement(link).click().perform();
	    	
	    	SleepUtils.mediumWait();
	        driver.navigate().back();
	    }
	    softassert.assertAll();
	}
	
	
	@Test(priority = 3, description = "Verify image interactions in Collaborative Research", groups = {"regression"})
	public void verifyCollaborativeResearchImages() {
		
	    String[] xpathsForImage = {
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[2]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[4]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[3]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[6]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/article[5]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]"
	    };

	    for (String imageClickAction : xpathsForImage) {
	        By imageLocator = By.xpath(imageClickAction);
	        WebElement image = driver.findElement(imageLocator);
	        act.scrollToElement(image).perform();
	        act.moveToElement(image).perform();
	        
	        WebElement imageClick = wait.waitForElementToBeClickable(imageLocator, 10);
	        act.moveToElement(imageClick).click().perform();

	        By fullScreenLocator = By.xpath("//body/div[19]/a[2]");
	        WebElement fullScreen = wait.waitForElementToBeClickable(fullScreenLocator, 10);
	        act.moveToElement(fullScreen).click().perform();

	        By slideshowLocator = By.xpath("//body/div[19]/a[3]");
	        WebElement slideshow = wait.waitForElementToBeClickable(slideshowLocator, 10);
	        act.moveToElement(slideshow).click().perform();
	        SleepUtils.longWait();  
	        act.moveToElement(slideshow).click().perform();  
	        SleepUtils.shortWait();

	        act.moveToElement(fullScreen).click().perform();
	        SleepUtils.shortWait();

	        By closeLocator = By.xpath("//body/div[19]/a[1]");
	        WebElement close = wait.waitForElementToBeClickable(closeLocator, 10);
	        act.moveToElement(close).click().perform();
	        SleepUtils.shortWait();
	    }

	    js.executeScript("window.scrollTo(0,0)");
	}


}

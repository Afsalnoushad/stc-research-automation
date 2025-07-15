package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.base.BaseClass;
import stthomas.stc_research_automation.utils.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ResearchHighlight extends BaseClass{
	
	
	@Test(priority = 1, description = "Navigate to Research Highlights and verify title/url", groups = {"smoke","regression"})
	public void navigateToResearchHighlights() {
		
		SoftAssert softassert=new SoftAssert();
		
		By ResearchHighlightLocator = By.xpath("//span[contains(text(),'RESEARCH HIGHLIGHTS')]");
		WebElement ResearchHighlightScroll = driver.findElement(ResearchHighlightLocator);
		act.scrollToElement(ResearchHighlightScroll).perform();
		
	    WebElement ResearchHighlight = wait.waitForElementToBeClickable(ResearchHighlightLocator, 10);
	    act.moveToElement(ResearchHighlight).click().perform();
	    
	    String ResearchHighlightTitle = driver.getTitle();
	    if(!ResearchHighlightTitle.equals("RESEARCH HIGHLIGHTS - St Thomas College (Autonomous)"))
	    {
	    	ScreenshotUtils.takeScreenShot(driver, "Research_Highlight_Title_Mismatch");
	    }
	    softassert.assertEquals(ResearchHighlightTitle, "RESEARCH HIGHLIGHTS - St Thomas College (Autonomous)","Title mismatch for Research Highlights");
	    String ResearchHighlightUrl = driver.getCurrentUrl();
	    if(!ResearchHighlightUrl.equals("research-highlights"))
	    {
	    	ScreenshotUtils.takeScreenShot(driver, "Research_Highligh_Url_Mismatch");
	    }
	    softassert.assertTrue(ResearchHighlightUrl.contains("research-highlights"),"Incorrect URL for Research Highlights page");
	    softassert.assertAll();
	}
	
	
	
	@Test(priority = 2, description = "Click redirect links under Research Highlights and return", groups = {"regression"})
	public void verifyResearchHighlightLinks() {
		String[] xpathLinkRedirect= {
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/article[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/article[1]/div[1]/div[2]/div[1]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/article[1]/div[1]/div[2]/div[1]/p[1]/span[1]/span[1]/a[1]",
				  "//a[contains(text(),'College News')]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/article[1]/div[1]/div[2]/div[1]/p[1]/a[2]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/article[1]/div[1]/div[2]/div[2]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/article[1]/div[1]/div[2]/div[2]/div[2]/a[1]/i[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[1]/div[3]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[2]/div[3]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[3]/div[3]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[4]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[4]/div[3]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[5]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[5]/div[3]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[6]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[6]/div[3]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[12]/div[1]/article[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[12]/div[1]/article[1]/div[3]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[12]/div[1]/article[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[12]/div[1]/article[2]/div[3]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[14]/div[1]/a[1]",
				  "//body[1]/div[7]/div[2]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[15]/div[1]/a[1]/span[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[26]/div[1]/article[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[26]/div[1]/article[1]/div[2]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[26]/div[1]/article[1]/div[4]/div[1]/span[1]/span[1]/a[1]",
				  "//a[contains(text(),'Research highlight papers')]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[26]/div[1]/article[1]/div[4]/div[2]/a[1]",
				  "//a[contains(text(),'0 Comments')]",
				  "//span[contains(text(),'STAFF PUBLICATIONS')]",
				  "//span[contains(text(),'STAFF PRESENTATIONS')]",
				  "//span[contains(text(),'STAFF PARTICIPATIONS')]",
				  "//span[contains(text(),'EVENTS')]",
				  "//span[contains(text(),'STUDENT PUBLICATIONS')]",
				  "//span[contains(text(),'STUDENT PRESENTATIONS')]",
				  "//span[contains(text(),'STUDENT PARTICIPATIONS')]"
				  
		  };

		for (String clickAction : xpathLinkRedirect) {
	    	
			WebElement link = driver.findElement(By.xpath(clickAction));
			  act.scrollToElement(link).perform();
			  SleepUtils.shortWait();
			  act.moveToElement(link).click().perform();
			  SleepUtils.mediumWait();
			  driver.navigate().back();
			  SleepUtils.shortWait();
	    }
	}
	

	
	@Test(priority = 3, description = "Open images in fullscreen & slideshow mode and close them", groups = {"regression"})
	public void verifyResearchHighlightImageSection() {
		String[] xpathImage = {
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/article[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[4]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[5]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/article[6]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[12]/div[1]/article[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[12]/div[1]/article[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[26]/div[1]/article[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]"
				  
		  };

	    for (String clickAction : xpathImage) {
	    	
	    	WebElement link = driver.findElement(By.xpath(clickAction));
		    act.scrollToElement(link).perform();
		    SleepUtils.shortWait();
		    act.moveToElement(link).click().perform();
		    SleepUtils.shortWait();
		    WebElement fullScreen = driver.findElement(By.xpath("//body/div[19]/a[2]"));
		    act.moveToElement(fullScreen).click().perform();
		    SleepUtils.shortWait();
		    WebElement slideShow = driver.findElement(By.xpath("//body/div[19]/a[3]"));
		    act.moveToElement(slideShow).click().perform();
		    SleepUtils.longWait();
		    act.moveToElement(slideShow).click().perform();
		    SleepUtils.shortWait();
		    WebElement close = driver.findElement(By.xpath("//body/div[19]/a[1]"));
		    act.moveToElement(close).click().perform();
	    }
	}
	
	@Test(priority = 4, description = "Verify pagination under Research Highlights", groups = {"regression"})
	public void verifyResearchHighlightPagination() {
	    String[] paginationXpath = {
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[2]/a[2]/span[1]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/div[2]/a[1]/span[2]"
	    };

	    for (String clickActionPagination : paginationXpath) {
	    	
	    	By linkLocator = By.xpath(clickActionPagination);
	    	WebElement linkScroll = driver.findElement(linkLocator);
	    	act.scrollToElement(linkScroll).perform();
	    	
	        WebElement link = wait.waitForElementToBeClickable(linkLocator, 10);
	        act.moveToElement(link).click().perform();
	        SleepUtils.mediumWait();
	    }
	}


}

package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.base.BaseClass;
import stthomas.stc_research_automation.utils.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ResearchProgrammes extends BaseClass{
	
	@Test(priority = 1, description = "Navigate to Research Programmes page and verify title/url", groups = {"smoke","regression"})
	public void verifyResearchProgrammes() {
		
	    SoftAssert softassert = new SoftAssert();
	    
	    By researchProgramLocator = By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li[8]/a[1]/span[1]");
	    WebElement researchProgram = wait.waitForElementToBeClickable(researchProgramLocator, 10);
	    act.moveToElement(researchProgram).click().perform();
	    
	    if (!driver.getTitle().equals("Research Programmes - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "ResearchProgrammes_TitleMismatch");
	    }
	    softassert.assertEquals(driver.getTitle(), "Research Programmes - St Thomas College (Autonomous)", "Research Programmes - Page title mismatch");

	    if (!driver.getCurrentUrl().contains("exchange-programmes")) {
	        ScreenshotUtils.takeScreenShot(driver, "ResearchProgrammes_URLMismatch");
	    }
	    softassert.assertTrue(driver.getCurrentUrl().contains("exchange-programmes"), "Did not navigate to Research Programmes");
	    softassert.assertAll();
	}
	
	@Test(priority = 2, description = "Check all Research Programme link redirects")
	public void checkResearchProgrammeLinks() {
		String[] linkRedirect = {
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[1]/div[3]/h2[1]/a[1]",
				  "//a[contains(text(),'jeswin')]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[1]/div[3]/p[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[1]/div[3]/p[1]/span[7]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[1]/div[5]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[2]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[2]/div[3]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[2]/div[3]/p[1]/span[1]/span[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[2]/div[3]/p[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[2]/div[3]/p[1]/span[7]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[2]/div[5]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[3]/div[3]/h2[1]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[3]/div[3]/p[1]/span[1]/span[1]/a[1]",
				  "//a[contains(text(),'College News')]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[3]/div[3]/p[1]/a[2]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[3]/div[3]/p[1]/span[7]/a[1]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/article[3]/div[5]/div[1]/a[1]"
		  };

		for (String clickAction : linkRedirect) {
	    	
			WebElement link = driver.findElement(By.xpath(clickAction));
			act.scrollToElement(link).perform();
			SleepUtils.shortWait();
			act.moveToElement(link).click().perform();
			SleepUtils.mediumWait();
			driver.navigate().back();
			wait.waitForTitleIs("Research Programmes - St Thomas College (Autonomous)", 10);
	    }
	}
	
	@Test(priority = 3, description = "Check pagination navigation in Research Programmes", groups = {"regression"})
	public void checkPaginationControls() {
		String[] paginationXpath = {
				  "//span[contains(text(),'Next')]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[2]/a[3]",
				  "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[2]/a[2]",
				  "//span[contains(text(),'Previous')]"
		  };

	    for (String clickAction : paginationXpath) {
	        WebElement link = driver.findElement(By.xpath(clickAction));
	        act.scrollToElement(link).perform();
	        SleepUtils.shortWait();
	        act.moveToElement(link).click().perform();
	        SleepUtils.mediumWait();
	    }
	}
	
	@Test(priority = 4, description = "Verify Invited Speakers page", groups = {"regression"})
	public void verifyInvitedSpeakersSection() {
		
	    SoftAssert softassert = new SoftAssert();
	    
	    By invspeakersLocator = By.xpath("//span[contains(text(),'Invited Speakers for various programmes')]");
	    WebElement invspeakersScroll = driver.findElement(invspeakersLocator);
	    act.scrollToElement(invspeakersScroll).perform();
	    
	    WebElement invspeakers = wait.waitForElementToBeClickable(invspeakersLocator, 10); 
	    invspeakers.click();
	    SleepUtils.mediumWait();

	    if (!driver.getTitle().equals("Invited speakers - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "InvitedSpeakers_TitleMismatch");
	    }
	    softassert.assertEquals(driver.getTitle(), "Invited speakers - St Thomas College (Autonomous)", "Invited speakers - Page title mismatch");

	    if (!driver.getCurrentUrl().contains("invited-speakers")) {
	        ScreenshotUtils.takeScreenShot(driver, "InvitedSpeakers_URLMismatch");
	    }
	    softassert.assertTrue(driver.getCurrentUrl().contains("invited-speakers"), "Did not navigate to Invited speakers page");

	    driver.navigate().back();
	    wait.waitForTitleIs("Research Programmes - St Thomas College (Autonomous)", 10);
	    softassert.assertAll();
	}
	
	@Test(priority = 4, description = "Verify table section", groups = {"regression"})
	public void verifyTableSection() {
		
		String[] tablePagination = {
		        "//body[1]/div[7]/div[2]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[11]/div[1]/div[4]/a[2]",
		        "//body[1]/div[7]/div[2]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[11]/div[1]/div[4]/a[1]"
		    };

		    for (String clickAction3 : tablePagination) {
		        WebElement link = driver.findElement(By.xpath(clickAction3));
		        act.scrollToElement(link).perform();
		        SleepUtils.shortWait();
		        act.moveToElement(link).click().perform();
		        SleepUtils.mediumWait();
		    }
		    WebElement showEntries = driver.findElement(By.name("tablepress-181_length"));
		    act.scrollToElement(showEntries).perform();
		    SleepUtils.shortWait();
			Select select = new Select(showEntries);
			select.selectByValue("25");
			js.executeScript("window.scrollBy(0,1800)");
			SleepUtils.mediumWait();
			js.executeScript("window.scrollBy(0,-1800)");
			SleepUtils.mediumWait();
			select.selectByValue("50");
			js.executeScript("window.scrollBy(0,2800)");
			SleepUtils.mediumWait();
			js.executeScript("window.scrollBy(0,-2400)");
			SleepUtils.mediumWait();
			String[] columnHeaders = {
					"Year",
					"Name of the workshop/ seminar",
					"Number of Participants",
					"Date From – To",
					"Link to the Activity report on the website"
			};
			for (String header : columnHeaders) {
				  
				WebElement column = driver.findElement(By.xpath("//th[contains(text(),'" + header + "')]"));
				column.click();
				SleepUtils.mediumWait();
			    column.click();
			    SleepUtils.shortWait();
		    }
			WebElement search = driver.findElement(By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[11]/div[1]/div[2]/label[1]/input[1]"));
			search.click();
			search.sendKeys("Psychological Autopsy-Skill Development");
			SleepUtils.mediumWait();
			search.clear();
			SleepUtils.mediumWait();
			search.sendKeys("Community Policing-Skill Development");
			SleepUtils.mediumWait();
			search.clear();
			SleepUtils.mediumWait();
			js.executeScript("window.scrollTo(0,0)");

	}


}

package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.base.BaseClass;
import stthomas.stc_research_automation.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Journals extends BaseClass{
	
	@Test(priority = 1, description = "Navigate to Journals section and verify title/url", groups = {"smoke","regression"})
	public void navigateToJournalsSection() {
	    SoftAssert softassert = new SoftAssert();
	    
	    By journalLocator = By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li[16]/a[1]/span[1]");
	    
	    WebElement journalScroll = driver.findElement(journalLocator);
	    act.scrollToElement(journalScroll).perform();
	    
	    WebElement journal = wait.waitForElementToBeClickable(journalLocator, 10);
	    act.moveToElement(journal).click().perform();

	    String journalTitle = driver.getTitle();
	    if (!journalTitle.equals("Journals - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "Journals_Title_Mismatch");
	    }
	    softassert.assertEquals(journalTitle, "Journals - St Thomas College (Autonomous)", "Journals - Page title mismatch");

	    String journalUrl = driver.getCurrentUrl();
	    if (!journalUrl.contains("journals")) {
	        ScreenshotUtils.takeScreenShot(driver, "Journals_URL_Mismatch");
	    }
	    softassert.assertTrue(journalUrl.contains("journals"), "Did not navigate to Journals page");

	    softassert.assertAll();
	}

	
	@Test(priority = 2, description = "Click View Journal Home Page and return", groups = {"regression"})
	public void viewJournalHomePageAndReturn() {
	    By viewJournalLocator = By.xpath("//span[contains(text(),'View Journal Home Page')]");

	    WebElement viewJournalScroll = driver.findElement(viewJournalLocator);
	    act.scrollToElement(viewJournalScroll).perform();

	    WebElement viewJournal = wait.waitForElementToBeClickable(viewJournalLocator, 10);
	    act.moveToElement(viewJournal).click().perform();

	    SleepUtils.mediumWait();
	    driver.navigate().back();
	}

	
	@Test(priority = 3, description = "Open and verify Journal Volumes", groups = {"regression"})
	public void verifyJournalVolumes() {
		String[] xpaths = {
				  "//span[contains(text(),'Vol.18 (2024)')]",
				  "//a[contains(text(),'Vol.17 (2023)')]",
				  "//a[contains(text(),'Vol.16 (2022)')]",
				  "//a[contains(text(),'Vol.15 (2021)')]",
				  "//a[contains(text(),'Vol.14 (2020)')]",
				  "//a[contains(text(),'Vol.13 (2019)')]",
				  "//a[contains(text(),'Vol.12 (2018)')]",
				  "//a[contains(text(),'Vol.11 (2017)')]",
				  "//a[contains(text(),'Vol.10 (2016)')]",
				  "//a[contains(text(),'Vol.09 (2015)')]",
				  "//a[contains(text(),'Vol.08 (2014)')]",
				  "//a[contains(text(),'Vol.07 (2013)')]",
				  "//span[contains(text(),'Vol.06 (2012)')]"		  
		  };

	    for (String clickAction : xpaths) {
	    	By linkLocator = By.xpath(clickAction);

	    	WebElement linkScroll = driver.findElement(linkLocator);
	    	act.scrollToElement(linkScroll).perform();

	    	WebElement link = wait.waitForElementToBeClickable(linkLocator, 10);
	    	act.moveToElement(link).click().perform();
	    	
	    	SleepUtils.mediumWait();
	        driver.navigate().back();
	        wait.waitForTitleIs("Journals - St Thomas College (Autonomous)", 10);
	        
	    }

	    js.executeScript("window.scrollTo(0,0)");
	}


}

package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.base.BaseClass;
import stthomas.stc_research_automation.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AwardsAndFellowships extends BaseClass{
	
	@Test(priority = 1, description = "Navigate to Awards and Fellowships page and verify title/url", groups = {"smoke","regression"})
	public void navigateToAwardsAndFellowshipsPage() {
		SoftAssert softassert=new SoftAssert();

	    By awardsAndFellowshipLocator = By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li[18]/a[1]/span[1]");
	    WebElement awardsAndFellowshipScroll = driver.findElement(awardsAndFellowshipLocator);
	    act.scrollToElement(awardsAndFellowshipScroll).perform();
	    
	    WebElement awardsAndFellowship = wait.waitForElementToBeClickable(awardsAndFellowshipLocator, 10);
	    act.moveToElement(awardsAndFellowship).click().perform();
	    
	    String title = driver.getTitle();
	    if (!title.equals("Awards & Fellowships - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "Awards_Fellowships_Title_Mismatch");
	    }
	    softassert.assertEquals(title, "Awards & Fellowships - St Thomas College (Autonomous)", "Title mismatch for Awards and Fellowships page");
	    String url = driver.getCurrentUrl();
	    if (!url.contains("research-fellowship/")) {
	        ScreenshotUtils.takeScreenShot(driver, "Awards_Fellowships_URL_Mismatch");
	    }
	    softassert.assertTrue(url.contains("research-fellowship/"), "Incorrect URL for Awards and Fellowships page");
	    softassert.assertAll();
	}
	
	@Test(priority = 2, description = "Verify the pagination controls next, prev, dropdown, search ...", groups = {"regression"})
	public void verifyPaginationControls() {

	    By nextLocator = By.cssSelector("#tablepress-162_next");
	    WebElement nextScroll = driver.findElement(nextLocator);
	    act.scrollToElement(nextScroll).perform();
	    WebElement next = wait.waitForElementToBeClickable(nextLocator, 10);
	    act.moveToElement(next).click().perform();

	    By previousLocator = By.cssSelector("#tablepress-162_previous");
	    WebElement previousScroll = driver.findElement(previousLocator);
	    act.scrollToElement(previousScroll).perform();
	    WebElement previous = wait.waitForElementToBeClickable(previousLocator, 10);
	    act.moveToElement(previous).click().perform();

	    By showEntriesLocator = By.xpath("//label/select[@name='tablepress-162_length']");
	    WebElement showEntriesScroll = driver.findElement(showEntriesLocator);
	    act.scrollToElement(showEntriesScroll).perform();
	    WebElement showEntries = wait.waitForElementToBeVisible(showEntriesLocator, 10);
	    Select select = new Select(showEntries);
	    select.selectByValue("25");
	    SleepUtils.shortWait();
	    js.executeScript("window.scrollBy(0,500)");
	    SleepUtils.shortWait();
	    select.selectByValue("50");
	    SleepUtils.shortWait();

	    String[] tableHeaderXpaths = {
	        "//th[contains(text(),'Resarch (SEED MONEY) Grant Proposal')]",
	        "//thead/tr[1]/th[2]",
	        "//thead/tr[1]/th[3]",
	        "//thead/tr[1]/th[4]",
	        "//thead/tr[1]/th[5]",
	        "//thead/tr[1]/th[6]"
	    };

	    for (String headerXpath : tableHeaderXpaths) {
	        By headerLocator = By.xpath(headerXpath);
	        WebElement headerScroll = driver.findElement(headerLocator);
	        act.scrollToElement(headerScroll).perform();
	        WebElement header = wait.waitForElementToBeClickable(headerLocator, 10);
	        act.moveToElement(header).click().perform();
	        SleepUtils.shortWait();
	        act.moveToElement(header).click().perform(); 
	        SleepUtils.shortWait();
	    }

	    By searchLocator = By.xpath("//input[@type='search' and @aria-controls='tablepress-162']");
	    WebElement searchScroll = driver.findElement(searchLocator);
	    act.scrollToElement(searchScroll).perform();
	    WebElement search = wait.waitForElementToBeVisible(searchLocator, 10);
	    search.click();
	    search.sendKeys("Zoology");
	    SleepUtils.mediumWait();
	    search.clear();
	    SleepUtils.shortWait();
	}

	
	@Test(priority = 3, description = "Verify link navigations and return back", groups = {"regression"})
	public void verifyLinkNavigationAndBack() {
	    String[] linkXpath = {
	        "//a[contains(text(),'BESTM National Fellowship')]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[13]/div[1]/article[1]/div[1]/div[1]/div[1]/p[1]/span[1]/span[1]/a[1]",
	        "//a[contains(text(),'College News')]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[13]/div[1]/article[1]/div[1]/div[1]/div[1]/p[1]/a[2]",
	        "//a[contains(text(),'Physics - Achievements')]",
	        "//a[contains(text(),'Read More')]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[13]/div[1]/article[1]/div[1]/div[1]/div[2]/div[2]/a[1]/i[1]"
	    };
	    for (String clickAction : linkXpath) {
	    	
	    	By linkLocator = By.xpath(clickAction);
	    	WebElement linkScroll = driver.findElement(linkLocator);
	    	act.scrollToElement(linkScroll).perform();
	    	
	        WebElement link = wait.waitForElementToBeClickable(linkLocator, 10);
	        act.moveToElement(link).click().perform();      
	        SleepUtils.mediumWait();
	        driver.navigate().back();
	    }
	    js.executeScript("window.scrollTo(0,0)");
	}
	

}

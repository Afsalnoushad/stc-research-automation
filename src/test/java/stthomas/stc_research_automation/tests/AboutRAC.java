package stthomas.stc_research_automation.tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.utils.*;
import stthomas.stc_research_automation.base.BaseClass;

public class AboutRAC extends BaseClass{
  
	@Test(priority = 1, description = "Validate About page title and verify title/url", groups = {"smoke","regression"})
	public void verifyAboutPageTitle() throws Exception {
		
		SoftAssert softassert = new SoftAssert();
		
		String title = driver.getTitle();
        if (!title.equals("About Research Advisory Council - St Thomas College (Autonomous)")) {
            ScreenshotUtils.takeScreenShot(driver, "Annual_Research_Report_Title_Mismatch");
        }
        softassert.assertEquals(title, "About Research Advisory Council - St Thomas College (Autonomous)", "About Research Advisory Council - Page title mismatch");

        String url = driver.getCurrentUrl();
        if (!url.contains("about-research-council")) {
            ScreenshotUtils.takeScreenShot(driver, "Annual_Research_Report_URL_Mismatch");
        }
        softassert.assertTrue(url.contains("about-research-council"), "Did not navigate to Annual Research Reports page");
	    softassert.assertAll();
	}

	@Test(priority = 2, description = "Navigate to Research Advisory Council", groups = {"regression"})
	public void verifyResearchCouncilNavigation() throws Exception {
		SoftAssert softassert = new SoftAssert();
		
		By researchAdvisoryLocator = By.xpath("//a[contains(text(),'RESEARCH ADVISORY COUNCIL')]");
	    WebElement researchAdvisoryCouncil = wait.waitForElementToBeClickable(researchAdvisoryLocator, 10);    
	    
	    act.moveToElement(researchAdvisoryCouncil).click().perform();
	    wait.waitForUrlContains("research-council-members", 10);
	    
	    String currentUrl = driver.getCurrentUrl();
	    if (!currentUrl.contains("research-council-members")) {
	        ScreenshotUtils.takeScreenShot(driver, "ResearchCouncil_Navigation_Failed");
	    }
	    softassert.assertTrue(currentUrl.contains("research-council-members"), "Did not navigate to Research Advisory Council page");
	    
	    driver.navigate().back();
	    wait.waitForTitleIs("About Research Advisory Council - St Thomas College (Autonomous)", 10);
	    softassert.assertAll();
	}

	@Test(priority = 3, description = "Verify PhD page navigation and title", groups = {"regression"})
	public void verifyPhdPageNavigation() throws Exception { 
		SoftAssert softassert = new SoftAssert();
		
		By clickHereLocator = By.xpath("//a[contains(text(),'click here.')]");
		WebElement clickHereScroll = driver.findElement(clickHereLocator);
		act.scrollToElement(clickHereScroll).perform();
		
	    WebElement clickHere = wait.waitForElementToBeClickable(clickHereLocator, 10);    
	    act.moveToElement(clickHere).click().perform();
	    
	    String phdTitle = driver.getTitle();
	    if (!phdTitle.equals("Ph.D. Awardees - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "PhDPage_TitleMismatch");
	    }
	    softassert.assertEquals(phdTitle, "Ph.D. Awardees - St Thomas College (Autonomous)", "Page title mismatch");
	    
	    driver.navigate().back();
	    wait.waitForTitleIs("About Research Advisory Council - St Thomas College (Autonomous)", 10);
	    softassert.assertAll();
	}

	
	@Test(priority = 4, description = "Verify PhD Awardees sections and headings", groups = {"regression"})
	public void verifyPhdAwardeesSections() throws Exception { 
		
		SoftAssert softassert = new SoftAssert();
		
		By dOPLocator = By.xpath("//span[contains(text(),'Doctor of Philosophy (PhD) Awardees of St.Thomas C')]");
	    
		WebElement dOPScroll = driver.findElement(dOPLocator);	    
	    act.scrollToElement(dOPScroll).perform();
	    
	    WebElement dOP = wait.waitForElementToBeClickable(dOPLocator, 10);
	    act.moveToElement(dOP).click().perform();
	    
	    By headingLocator = By.tagName("h2");
	    wait.waitForElementToBeVisible(headingLocator, 10);
	    
	    WebElement heading = driver.findElement(headingLocator);
	    String actualHeading = heading.getText();
	    
	    if (!actualHeading.equals("PhD Awardees")) {
	        ScreenshotUtils.takeScreenShot(driver, "PhDHeadingMismatch");
	    }
	    softassert.assertEquals(actualHeading, "PhD Awardees", "Heading text mismatch");

	    String[] xpaths = {
	        "//span[contains(text(),'BOTANY')]",
	        "//span[contains(text(),'CHEMISTRY')]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[3]/div[1]/h4[1]/a[1]/span[2]",
	        "//span[contains(text(),'ECONOMICS')]",
	        "//span[contains(text(),'ENGLISH')]",
	        "//span[contains(text(),'MATHEMATICS')]",
	        "//span[contains(text(),'STATISTICS')]",
	        "//span[contains(text(),'ZOOLOGY')]"
	    };

	    for(String clickAction: xpaths) {
			  WebElement link = driver.findElement(By.xpath(clickAction));
			  act.scrollToElement(link).perform();
			  SleepUtils.shortWait();
			  act.moveToElement(link).click().perform();
			  SleepUtils.shortWait();
			  js.executeScript("window.scrollBy(0,300)");
			  SleepUtils.shortWait();
			  act.moveToElement(link).click().perform();
			  SleepUtils.shortWait();
		  }

	    driver.navigate().back();
	    wait.waitForTitleIs("About Research Advisory Council - St Thomas College (Autonomous)", 10);
	    softassert.assertAll();
	}

	
	@Test(priority = 5, description = "Verify external link to Directorate of Research", groups = {"regression"})
	public void verifyDirectorateOfResearchLink() throws Exception { 
		SoftAssert softassert = new SoftAssert();
	    String mainWindow = driver.getWindowHandle();	
	    
	    By dORLocator = By.xpath("//a[contains(text(),'Directorate of Research, University of Calicut')]");
	    
	    WebElement dORLocatorSroll = driver.findElement(dORLocator);
	    act.scrollToElement(dORLocatorSroll).perform();
	    
	    WebElement dOR = wait.waitForElementToBeClickable(dORLocator, 10);   
	    act.moveToElement(dOR).click().perform();
	    
        
	    Set<String> allWindow = driver.getWindowHandles();
	    for(String windowHandle : allWindow) {
	        if(!windowHandle.equals(mainWindow)) {
	            driver.switchTo().window(windowHandle);	
	            By headingLocator = By.xpath("//h3[contains(text(),'Directorate of Research')]");
	            wait.waitForElementToBeVisible(headingLocator, 10);
	            softassert.assertEquals(driver.getTitle(),"Home","Page title mismatch");
	            driver.close();
	            driver.switchTo().window(mainWindow);
	        }
	    }
	    softassert.assertAll();
	}

	@Test(priority = 6, description = "Verify Annual Research Reports", groups = {"regression"})
	public void verifyAnnualResearchReports() throws Exception { 
		SoftAssert softassert = new SoftAssert();
	    String[] xpaths2 = {
	        "//a[contains(text(),'Annual Research Report 2021(Jan 1 to Dec 31)')]",
	        "//a[contains(text(),'Annual Research Report 2019 (Jan 1 to Dec 31)')]",
	        "//a[contains(text(),'Annual Research Report 2018 (Jan 1 to Dec 31)')]"	  
	    };
	    for(String clickAction2 : xpaths2) {
	    	
	    	By linkLocator = By.xpath(clickAction2);
	    	WebElement linkScroll = driver.findElement(linkLocator);
	    	act.scrollToElement(linkScroll).perform();
	    	
	        WebElement link = wait.waitForElementToBeClickable(linkLocator, 10);
	        act.moveToElement(link).click().perform();
	        
	    }
        
	    By aRR2020Locator = By.xpath("//a[contains(text(),'Annual Research Report 2020 (Jan 1 to Dec 31)')]");
	    WebElement aRR2020 = wait.waitForElementToBeClickable(aRR2020Locator, 10);
	    
	    act.scrollToElement(aRR2020).perform();
	    act.moveToElement(aRR2020).click().perform();
	    
	    String annualReportUrl = driver.getCurrentUrl();
	    if (!annualReportUrl.contains("Annual_Research_Report_2020.pdf")) {
	        ScreenshotUtils.takeScreenShot(driver, "AnnualReport2020_Navigation_Failed");
	    }
	    softassert.assertTrue(annualReportUrl.contains("Annual_Research_Report_2020.pdf"), "Did not navigate to Annual research report 2020");
	    
	    driver.navigate().back();
	    wait.waitForTitleIs("About Research Advisory Council - St Thomas College (Autonomous)", 10);
	    js.executeScript("window.scrollTo(0,0)");
	    softassert.assertAll();
	}

	
}

package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import stthomas.stc_research_automation.utils.*;
import stthomas.stc_research_automation.base.BaseClass;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResearchRegulations extends BaseClass{
	
	@Test(priority=1, description="Navigate to  Research Regulations Page and verify Title and URL", groups = {"smoke","regression"})
	public void verifyResearchRegulationsPage() throws Exception {
		
	    SoftAssert softassert = new SoftAssert();
	    
	    By researchregulatnLocator = By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li[5]/a[1]/span[1]");
	    WebElement researchregulatn = wait.waitForElementToBeClickable(researchregulatnLocator, 10);
	    act.moveToElement(researchregulatn).click().perform();

	    String researchRegulationsTitle = driver.getTitle();
	    if (!researchRegulationsTitle.equals("Research Regulations - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "Research_Regulations_Title_Mismatch");
	    }
	    softassert.assertEquals(researchRegulationsTitle, "Research Regulations - St Thomas College (Autonomous)", "Research Regulations - Page title mismatch");

	    String researchRegulationsUrl = driver.getCurrentUrl();
	    if (!researchRegulationsUrl.contains("research-regulations")) {
	        ScreenshotUtils.takeScreenShot(driver, "Research_Regulations_URL_Mismatch");
	    }
	    softassert.assertTrue(researchRegulationsUrl.contains("research-regulations"), "Did not navigate to Research Regulations");
	    softassert.assertAll();
	}

	
	@Test(priority=2, description="Verify External Link to Directorate of Research", groups = {"regression"})
	public void verifyDirectorateOfResearchLink() throws Exception {
		
	    SoftAssert softassert = new SoftAssert();
	    
	    String mainWindow = driver.getWindowHandle();
	    WebElement DOR = driver.findElement(By.xpath("//a[contains(text(),'Directorate of Research, University of Calicut')]"));
	    DOR.click();
	    
	    String dorTitle = driver.getTitle();
	    if (!dorTitle.equals("Home")) {
	        ScreenshotUtils.takeScreenShot(driver, "DOR_Title_Mismatch");
	    }
	    softassert.assertEquals(dorTitle, "Home", "DOR Page - Title mismatch");

	    String dorUrl = driver.getCurrentUrl();
	    if (!dorUrl.contains("dor.uoc.ac.in/")) {
	        ScreenshotUtils.takeScreenShot(driver, "DOR_URL_Mismatch");
	    }
	    softassert.assertTrue(dorUrl.contains("dor.uoc.ac.in/"), "DOR Page - URL mismatch");

	    Set<String> allwindow = driver.getWindowHandles();
	    String title = "";
	    for (String windowHandle : allwindow) {
	        if (!windowHandle.equals(mainWindow)) {
	            driver.switchTo().window(windowHandle);
	            title = driver.getTitle();
	        }
	        if (title.equals("Home")) {
	            driver.switchTo().window(windowHandle);
	            SleepUtils.mediumWait();
	            driver.close();
	        }
	    }
	    driver.switchTo().window(mainWindow);
	    softassert.assertAll();
	}

	
	@Test(priority=3, description="Verify Circulars and Orders Page", groups = {"regression"})
	public void verifyCircularsAndOrdersLink() throws Exception {
		
	    SoftAssert softassert = new SoftAssert();

	    WebElement CandO = driver.findElement(By.xpath("//a[contains(text(),'Circulars & Orders of University of Calicut')]"));
	    CandO.click();

	    String circularsTitle = driver.getTitle();
	    if (!circularsTitle.equals("Notifications & Orders")) {
	        ScreenshotUtils.takeScreenShot(driver, "Circulars_Orders_Title_Mismatch");
	    }
	    softassert.assertEquals(circularsTitle, "Notifications & Orders", "Circulars & Orders of University of Calicut - Page title mismatch");

	    String circularsUrl = driver.getCurrentUrl();
	    if (!circularsUrl.contains("2016-06-16-10-20-34/2017-08-14-14-53-59")) {
	        ScreenshotUtils.takeScreenShot(driver, "Circulars_Orders_URL_Mismatch");
	    }
	    softassert.assertTrue(circularsUrl.contains("2016-06-16-10-20-34/2017-08-14-14-53-59"), "Did not navigate to Circulars & Orders of University of Calicut");

	    SleepUtils.mediumWait();
	    driver.navigate().back();
	    softassert.assertAll();
	}

	
	@Test(priority=4, description="Verify Plagiarism and Research Regulations Files", groups = {"regression"})
	public void verifyPlagiarismAndRegulationFiles() throws Exception {
		

	    WebElement plagiarismcp = driver.findElement(By.xpath("//span[contains(text(),'Plagiarism Check Policy 2019')]"));
	    act.scrollToElement(plagiarismcp).perform();
	    plagiarismcp.click();
	    SleepUtils.shortWait();

	    WebElement researchRegulation = driver.findElement(By.xpath("//span[contains(text(),'Research Regulations 2019')]"));
	    researchRegulation.click();
	    SleepUtils.shortWait();
	}

	
	@Test(priority=5, description="Verify Annual Research Report Navigation", groups = {"regression"})
	public void verifyAnnualResearchReportNavigation() throws Exception {
		
	    SoftAssert softassert = new SoftAssert();
	    
	    WebElement AnnualRR = driver.findElement(By.xpath("//a[contains(text(),'Annual Research Report 2020 (Jan 1 to Dec 31)')]"));
	    act.scrollToElement(AnnualRR).perform();
	    SleepUtils.shortWait();

	    WebElement doClickHere = driver.findElement(By.xpath("//a[contains(text(),'click here')]"));
	    doClickHere.click();
	    SleepUtils.mediumWait();
	    
	    String clickHereTitle = driver.getTitle();
	    if (!clickHereTitle.contains("www.universityofcalicut.info")) {
	        ScreenshotUtils.takeScreenShot(driver, "Click_Here_Title_Mismatch");
	    }
	    softassert.assertTrue(clickHereTitle.contains("www.universityofcalicut.info"), "Unexpected title after clicking 'click here'");
	    String clickHereUrl = driver.getCurrentUrl();
	    if (!clickHereUrl.contains("universityofcalicut.info/dor/")) {
	        ScreenshotUtils.takeScreenShot(driver, "Click_Here_URL_Mismatch");
	    }
	    softassert.assertTrue(clickHereUrl.contains("universityofcalicut.info/dor/"), "Unexpected URL after clicking 'click here'");
	    driver.navigate().back();
	    wait.waitForTitleIs("Research Regulations - St Thomas College (Autonomous)", 10);
        
	    AnnualRR.click();
	    SleepUtils.mediumWait();
	    String annualRRUrl = driver.getCurrentUrl();
	    if (!annualRRUrl.contains("Annual_Research_Report_2020.pdf")) {
	        ScreenshotUtils.takeScreenShot(driver, "Annual_RR_URL_Mismatch");
	    }
	    softassert.assertTrue(annualRRUrl.contains("Annual_Research_Report_2020.pdf"), "Annual Research Report PDF URL mismatch");
	    driver.navigate().back();
	    wait.waitForTitleIs("Research Regulations - St Thomas College (Autonomous)", 10);
	    js.executeScript("window.scrollTo(0,0)");
	    softassert.assertAll();
	}


}

package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.base.BaseClass;
import stthomas.stc_research_automation.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResearchProjects extends BaseClass{
	
	@Test(priority = 1, description = "Navigate to Research Projects section and verify title/url", groups = {"smoke","regression"})
	public void verifyResearchProjectsSection() {
		
		SoftAssert softassert = new SoftAssert();
		
		By researchProjectsLocator = By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li[14]/a[1]/span[1]");
		WebElement researchProjectsScroll = driver.findElement(researchProjectsLocator);
		act.scrollToElement(researchProjectsScroll).perform();
		
	    WebElement researchProjects = wait.waitForElementToBeClickable(researchProjectsLocator, 10);
	    act.moveToElement(researchProjects).click().perform();
	    
	    String researchProjectsTitle = driver.getTitle();
	    if (!researchProjectsTitle.equals("Research Projects - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "Research_Projects_Title_Mismatch");
	    }
	    softassert.assertEquals(researchProjectsTitle, "Research Projects - St Thomas College (Autonomous)", "Research Projects - Page title mismatch");
	    String researchProjectsUrl = driver.getCurrentUrl();
	    if (!researchProjectsUrl.contains("completed-research-projects")) {
	        ScreenshotUtils.takeScreenShot(driver, "Research_Projects_URL_Mismatch");
	    }
	    softassert.assertTrue(researchProjectsUrl.contains("completed-research-projects"), "Did not navigate to Research Projects page");
	    softassert.assertAll();
	}
	
	@Test(priority = 2, description = "Check download links under Research Projects", groups = {"regression"})
	public void VerifyAllDownloadLinks() {
		String[] xpathsForDownloadLinks = {
				 "//a[contains(text(),'Executive summery and published paper of the work ')]",
				 "//a[contains(text(),'Assessment of constituents of essential oil in int')]",
				 "//a[contains(text(),'Assessment and Mapping of riparian forest vegetati')]",
				 "//a[contains(text(),'‘SOCIAL CAPITAL FORMATION AND ITS IMPACT ON THE PE')]",
				 "//a[contains(text(),'Executive summary of Minor Research Project, F.No.')]",
				 "//a[contains(text(),'Executive summary of my Minor Research Project 158')]",
				 "//a[contains(text(),'Executive Summary of Minor Research Project on Ent')]",
				 "//a[contains(text(),'Executive Summary of “Radiation properties of meta')]",
				 "//a[contains(text(),'EXECUTIVE SUMMARY OF MRP REF. NO. MRP/12th PLAN/14')]",
				 "//a[contains(text(),'Executive Summary of MRP(S)-0603/13-14/KLCA019/UGC')]",
				 "//a[contains(text(),'“Development of frequency selective split resonato')]",
				 "//a[contains(text(),'Title of research project: Robust Multivariate Ana')]",
				 "//a[contains(text(),'Executive Summary of UGC Minor Research Project 20')]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[22]/a[1]",
				 "//a[contains(text(),'EXECUTIVE SUMMARY WORK DONE ON THE PROJECT of Dr.B')]"
	  
	  };

	    for (String linkClickAction : xpathsForDownloadLinks) {
	        WebElement link = driver.findElement(By.xpath(linkClickAction));
	        act.scrollToElement(link).perform();
	        SleepUtils.shortWait();
	        act.moveToElement(link).click().perform();
	        SleepUtils.shortWait();
	    }
	    
	    
	}
	
	@Test(priority = 3, description = "Check redirection links under Research Projects", groups = {"regression"})
	public void VerifyAllRedirectLinks() {
		
		String[] xpathsForRedirectLinks = {
				 "//a[contains(text(),'Executive summary report of my Minor Research Proj')]",
				 "//a[contains(text(),'EXECUTIVE SUMMARY “A STUDY ON THE EFFECTIVE UTILIZ')]",
				 "//a[contains(text(),'https://stthomas.ac.in/files/content/1556271079047')]",
				 "//a[contains(text(),'FINAL REPORT OF MINOR RESEARCH PROJECT ON NANOFLUI')]",
				 "//a[contains(text(),'Executive summary of the research work done by TD ')]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[14]/a[1]",
				 "//a[contains(text(),'MRP entitled ” A CASE STUDY ON ECO-CRISIS AND HEAL')]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[15]/a[1]",
				 "//a[contains(text(),'MRP entitled “Preparation and characterization of ')]",
				 "//a[contains(text(),'Executive Summary of  MRP(S)-0602/13-14/KLCA019/UG')]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[18]/a[1]",
				 "//a[contains(text(),'EXECUTIVE SUMMARY  REPORT OF THE WORK DONE UNDER  ')]",
				 "//a[contains(text(),'Executive summary of the research work done by SAJ')]",
				 "//a[contains(text(),'UGC Reference No. : MRP(S) – 0604/13-14/KLCA019/UG')]",
				 "//a[contains(text(),'Dr. V. M. Chacko')]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[24]/a[2]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[24]/a[3]",
				 "//a[contains(text(),'Mr. P. L. Antony')]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[25]/a[2]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[25]/a[3]",
				 "//a[contains(text(),'Dr. C. F. Binoy')]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[26]/a[2]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[26]/a[3]",
				 "//a[contains(text(),'Dr.Anto Thomas C')]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[27]/a[2]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[27]/a[3]",
				 "//a[contains(text(),'Dr. Thomas Paul Kattukkaran')]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[28]/a[2]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[28]/a[3]",
				 "//a[contains(text(),'Dr. Ramkumar T B.')]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[29]/a[2]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[29]/a[3]",
				 "//a[contains(text(),'Dr.Sr.Alphonsa Mathew (UGC Minor, Mathematics, 201')]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[32]/div[1]/a[2]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[32]/div[1]/a[3]",
				 "//a[contains(text(),'Dr.Sabulayan (UGC Minor, Economics, 2014-15)')]",
				 "//a[contains(text(),'Dr. Francy K Kakkassery')]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[36]/div[1]/a[2]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[42]/div[1]/a[1]",
				 "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/ul[1]/li[42]/div[1]/a[2]"
				   
	  };

	    for (String linkClickAction : xpathsForRedirectLinks) {
	        WebElement link = driver.findElement(By.xpath(linkClickAction));
	        act.scrollToElement(link).perform();
	        SleepUtils.shortWait();
	        act.moveToElement(link).click().perform();
	        SleepUtils.mediumWait();
	        driver.navigate().back();
	        wait.waitForTitleIs("Research Projects - St Thomas College (Autonomous)", 10);
	    }
	}
	
	@Test(priority = 4, description = "Check Research Projects table functionality", groups = {"regression"})
	public void VerifyResearchProjectTable() {

	    WebElement scroll = driver.findElement(By.xpath(
	        "//body[1]/div[7]/div[2]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[8]/div[1]/table[1]/tbody[1]/tr[4]/td[1]"));
	    act.scrollToElement(scroll).click().perform();

	    String[] tableHeaderXpath = {
	        "//th[contains(text(),'Investigator')]",
	        "//body[1]/div[7]/div[2]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[8]/div[1]/table[1]/thead[1]/tr[1]/th[2]",
	        "//th[contains(text(),'Agency and Period')]",
	        "//th[contains(text(),'Amount (Rs.)')]"
	    };

	    for (String clickActionHeader : tableHeaderXpath) {
	        WebElement header = driver.findElement(By.xpath(clickActionHeader));
	        act.moveToElement(header).click().perform();
	        SleepUtils.shortWait();
	        act.moveToElement(header).click().perform();
	        SleepUtils.shortWait();
	    }

	    WebElement search = driver.findElement(By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[8]/div[1]/div[2]/label[1]/input[1]"));
	    search.click();
	    search.sendKeys("Sindhu George");
	    SleepUtils.shortWait();
	    search.clear();
	    SleepUtils.shortWait();
	    search.sendKeys("A study on the effective utilization of Open Source Software (OSS) in Governance");
	    SleepUtils.shortWait();
	    search.clear();
	    SleepUtils.shortWait();

	    js.executeScript("window.scrollTo(0,0)");
	}


}

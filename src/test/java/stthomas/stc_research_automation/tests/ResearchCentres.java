package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.base.BaseClass;
import stthomas.stc_research_automation.utils.*;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResearchCentres extends BaseClass {
	

	@Test(priority = 1, description = "Navigate to Research Centres Page and check title/url", groups = {"smoke","regression"})
	public void navigateToResearchCentres() throws Exception {
		
	    SoftAssert softassert = new SoftAssert();
	    By researchCentreLocator = By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li[3]/a[1]/span[1]");
	    WebElement researchCentre = wait.waitForElementToBeVisible(researchCentreLocator, 10); 
	    act.moveToElement(researchCentre).click().perform();
	    SleepUtils.shortWait();
	    
	    String title1 = driver.getTitle();
	    if (!title1.equals("Research Centres - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "ResearchCentres_TitleMismatch");
	    }
	    softassert.assertEquals(title1, "Research Centres - St Thomas College (Autonomous)", "Research Centres - Page title mismatch");

	    String url1 = driver.getCurrentUrl();
	    if (!url1.contains("research-centres")) {
	        ScreenshotUtils.takeScreenShot(driver, "ResearchCentres_URLMismatch");
	    }
	    softassert.assertTrue(url1.contains("research-centres"), "Did not navigate to research-centres page");
	    softassert.assertAll();
	}
	
	@Test(priority = 2, description = "Open and Verify Research Centre Departments", groups = {"regression"})
	public void ResearchCentres_DepartmentTabs() throws Exception {
		SleepUtils.mediumWait();
	    WebElement scroll = driver.findElement(By.xpath("//a[contains(text(),'DEPARTMENT OF COMPUTER SCIENCE')]"));
	    act.scrollToElement(scroll).perform();
	    String mainWindow = driver.getWindowHandle();
	    String[] xpaths = {
	        "//a[contains(text(),'DEPARTMENT OF ENGLIS')]",
	        "//a[contains(text(),'DEPARTMENT OF ZOOLOGY')]",
	        "//a[contains(text(),'DEPARTMENT OF CHEMISTRY')]",
	        "//a[contains(text(),'DEPARTMENT OF STATISTICS')]",
	        "//a[contains(text(),'DEPARTMENT OF COMMERCE')]",
	        "//a[contains(text(),'DEPARTMENT OF ECONOMICS')]",
	        "//a[contains(text(),'DEPARTMENT OF BOTANY')]",
	        "//a[contains(text(),'DEPARTMENT OF MATHEMATICS')]",
	        "//a[contains(text(),'DEPARTMENT OF PHYSICS')]"
	    };

	    for (String clickAction : xpaths) {
	        WebElement link = driver.findElement(By.xpath(clickAction));
	        link.click();
	    }

	    Set<String> allWindow = driver.getWindowHandles();
	    String title = "";

	    for (String windowHandle : allWindow) {
	        if (!windowHandle.equals(mainWindow)) {
	            driver.switchTo().window(windowHandle);
	            title = driver.getTitle();

	            if (title.equals("English - St Thomas College (Autonomous)")) {
	                WebElement scroll2 = driver.findElement(By.xpath("//body[1]/div[7]/div[2]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/p[5]"));
	                act.scrollToElement(scroll2).perform();
	                WebElement scroll3 = driver.findElement(By.xpath("//body[1]/div[7]/div[2]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/p[11]"));
	                act.scrollToElement(scroll3).perform();
	                driver.close();
	            }

	            if (title.equals("Deparment of Zoology | St. Thomas College Thrissur")) {
	                WebElement scroll4 = driver.findElement(By.xpath("//p[contains(text(),'Ph.D  Zoology')]"));
	                act.scrollToElement(scroll4).perform();
	                driver.close();
	            }

	            if (title.equals("Department of Chemistry | St. Thomas College (Autonomous) College")) {
	                WebElement scroll5 = driver.findElement(By.xpath("//p[contains(text(),'The Department is proud of its prestigious alumni ')]"));
	                act.scrollToElement(scroll5).perform();
	                driver.close();
	            }

	            if (title.equals("Department of Statistics | St. Thomas College Thrissur")) {
	                WebElement scroll6 = driver.findElement(By.xpath("//strong[contains(text(),'About Us')]"));
	                act.scrollToElement(scroll6).perform();
	                WebElement scroll7 = driver.findElement(By.xpath("//p[contains(text(),'The department conducts day observations every yea')]"));
	                act.scrollToElement(scroll7).perform();
	                WebElement scroll8 = driver.findElement(By.xpath("//li[contains(text(),'Industrial / Institutional Visits')]"));
	                act.scrollToElement(scroll8).perform();
	                driver.close();
	            }

	            if (title.equals("Commerce - St Thomas College (Autonomous)")) {
	                WebElement scroll9 = driver.findElement(By.xpath("//p[contains(text(),'The prominent alumni of the department include emi')]"));
	                act.scrollToElement(scroll9).perform();
	                driver.close();
	            }

	            if (title.equals("Economics Department St. Thomas College Thrissur")) {
	                WebElement scroll10 = driver.findElement(By.xpath("//p[contains(text(),'The latest programme organized by the department w')]"));
	                act.scrollToElement(scroll10).perform();
	                driver.close();
	            }

	            if (title.equals("Department of Botany | St. Thomas College (Autonomous) Thrissur")) {
	                WebElement scroll11 = driver.findElement(By.xpath("//p[contains(text(),'Certificate course in Horticulture (for UG student')]"));
	                act.scrollToElement(scroll11).perform();
	                WebElement scroll12 = driver.findElement(By.xpath("//strong[contains(text(),'Environmental Restoration and Conservation:')]"));
	                act.scrollToElement(scroll12).perform();
	                driver.close();
	            }

	            if (title.equals("Department of Mathematics | St. Thomas College Thrissur")) {
	                WebElement scroll13 = driver.findElement(By.xpath("//li[contains(text(),'Introduction to Differential Calculus (online)')]"));
	                act.scrollToElement(scroll13).perform();
	                WebElement scroll14 = driver.findElement(By.xpath("//p[contains(text(),'Dr. P .L. Antony was the first controller of exami')]"));
	                act.scrollToElement(scroll14).perform();
	                driver.close();
	            }

	            if (title.equals("Department of Physics | St. Thomas College Thrissur")) {
	                js.executeScript("window.scrollBy(0,700)");
	                driver.close();
	            }
	        }
	    }

	    driver.switchTo().window(mainWindow);
	}

	@Test(priority = 3, description = "Open CS Department Page and Navigate Back", groups = {"regression"})
	public void ResearchCentres_ComputerScienceVisit() throws Exception {
	    
		By csDeptLocator = By.xpath("//a[contains(text(),'DEPARTMENT OF COMPUTER SCIENCE')]");
		WebElement csDept = wait.waitForElementToBeVisible(csDeptLocator, 10); 
		csDept.click();
		
	    js.executeScript("window.scrollBy(0,700)");
	    SleepUtils.shortWait();
	    js.executeScript("window.scrollBy(0,700)");
	    SleepUtils.shortWait();
	    driver.navigate().back();
	}

	
	@Test(priority = 4, description = "Scroll and Click All Research Guides and Scholars", groups = {"regression"})
	public void ResearchCentres_ResearchGuideScholarSections() throws Exception {
	    String[] xpaths2 = {
	        "//span[contains(text(),'ENGLISH RESEARCH GUIDES')]",
	        "//span[contains(text(),'CHEMISTRY RESEARCH GUIDES')]",
	        "//span[contains(text(),'ZOOLOGY RESEARCH GUIDES')]",
	        "//span[contains(text(),'COMMERCE RESEARCH GUIDES')]",
	        "//span[contains(text(),'STATISTICS RESEARCH GUIDES')]",
	        "//span[contains(text(),'ECONOMICS RESEARCH GUIDES')]",
	        "//span[contains(text(),'MATHEMATICS RESEARCH GUIDES')]",
	        "//span[contains(text(),'BOTANY RESEARCH GUIDES')]",
	        "//span[contains(text(),'PHYSICS RESEARCH GUIDES')]",
	        "//span[contains(text(),'COMPUTER SCIENCE RESEARCH GUIDES')]",
	        "//span[contains(text(),'ENGLISH RESEARCH SCHOLARS')]",
	        "//span[contains(text(),'CHEMISTRY RESEARCH SCHOLARS')]",
	        "//span[contains(text(),'ZOOLOGY RESEARCH SCHOLARS')]",
	        "//span[contains(text(),'COMMERCE RESEARCH SCHOLARS')]",
	        "//span[contains(text(),'STATISTICS RESEARCH SCHOLARS')]",
	        "//span[contains(text(),'ECONOMICS RESEARCH SCHOLARS')]",
	        "//span[contains(text(),'MATHEMATICS RESEARCH SCHOLARS')]",
	        "//span[contains(text(),'BOTANY RESEARCH SCHOLARS')]",
	        "//span[contains(text(),'PHYSICS RESEARCH SCHOLARS')]",
	        "//span[contains(text(),'COMPUTER SCIENCE RESEARCH SCHOLARS')]",
	        "//span[contains(text(),'TITLE OF THESIS')]"
	    };

	    for (String clickAction : xpaths2) {
	    	
	    	By linkLocator = By.xpath(clickAction);
	    	WebElement linkScroll = driver.findElement(linkLocator);
	    	act.scrollToElement(linkScroll).perform();
	        WebElement link = wait.waitForElementToBeClickable(linkLocator, 10);
	        act.moveToElement(link).click().perform();
	        SleepUtils.shortWait();
	        js.executeScript("window.scrollBy(0,200)");
	        SleepUtils.shortWait();
	        act.moveToElement(link).click().perform();
	        SleepUtils.shortWait();
	    }
	}

	
	@Test(priority = 5, description = "Verify Research Scholar Data Capturing Link", groups = {"regression"})
	public void ResearchCentres_DataCaptureLink() throws Exception {
	    SoftAssert softassert = new SoftAssert();
	    
	    By captureLinkLocator = By.xpath("//span[contains(text(),'DATA CAPTURING LINK FOR RESEARCH SCHOLARS')]");
	    WebElement captureLink = wait.waitForElementToBeVisible(captureLinkLocator, 10);
	    act.moveToElement(captureLink).click().perform();
	    
	    String scholarUrl = driver.getCurrentUrl();
	    if (!scholarUrl.contains("rb.gy/hrkuwm")) {
	        ScreenshotUtils.takeScreenShot(driver, "DataCapturingLink_Navigation_Failed");
	    }
	    softassert.assertTrue(scholarUrl.contains("rb.gy/hrkuwm"), "Did not navigate to DATA CAPTURING LINK FOR RESEARCH SCHOLARS");
	    SleepUtils.mediumWait();
	    driver.navigate().back();
	    wait.waitForTitleIs("Research Centres - St Thomas College (Autonomous)", 10);
	    js.executeScript("window.scrollTo(0,0)");
	    softassert.assertAll();
	}



}

package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.base.BaseClass;
import stthomas.stc_research_automation.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RandPEthics2021 extends BaseClass{
	
	
	@Test(priority = 1, description = "Navigate to Research and Publication Ethics 2021 page and verify title/url", groups = {"smoke","regression"})
	public void verifyResearchRegulationsPage() {
		SoftAssert softassert = new SoftAssert();
		
		By RAndPEthics2021Locator = By.xpath("//span[contains(text(),'Research and Publication Ethics 2021')]");
		WebElement RAndPEthics2021Scroll = driver.findElement(RAndPEthics2021Locator);
		act.scrollToElement(RAndPEthics2021Scroll).perform();
		
	    WebElement RAndPEthics2021 = wait.waitForElementToBeClickable(RAndPEthics2021Locator, 10);
	    act.moveToElement(RAndPEthics2021).click().perform();

	    String researchEthicsTitle = driver.getTitle();
	    if (!researchEthicsTitle.equals("RESEARCH AND PUBLICATION ETHICS 2021 - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "Research_Ethics_Title_Mismatch");
	    }
	    softassert.assertEquals(researchEthicsTitle, "RESEARCH AND PUBLICATION ETHICS 2021 - St Thomas College (Autonomous)", "Research Ethics 2021 - Page title mismatch");
	    String researchEthicsUrl = driver.getCurrentUrl();
	    if (!researchEthicsUrl.contains("research-and-publication-ethics-2021")) {
	        ScreenshotUtils.takeScreenShot(driver, "Research_Ethics_URL_Mismatch");
	    }
	    softassert.assertTrue(researchEthicsUrl.contains("research-and-publication-ethics-2021"), "Did not navigate to Research Ethics page");
	    softassert.assertAll();
	}
	
	@Test(priority=2, description = "Verify brochure link ", groups = {"regression"})
	public void verifyBrochureLink(){
		SoftAssert softassert = new SoftAssert();
		By linkLocator = By.xpath("//a[contains(text(),'Brochure')]");
	    WebElement link = wait.waitForElementToBeClickable(linkLocator, 10);
	    act.moveToElement(link).click().perform();
	    
	    SleepUtils.mediumWait();
	    
	    String brochureUrl = driver.getCurrentUrl();
	    if (!brochureUrl.contains("RPE-COURSE-BROCHURE-1.jpg")) {
	        ScreenshotUtils.takeScreenShot(driver, "Brochure_URL_Mismatch");
	    }
	    softassert.assertTrue(brochureUrl.contains("RPE-COURSE-BROCHURE-1.jpg"), "Brochure link did not open the expected image");
	    driver.navigate().back();
	    wait.waitForTitleIs("RESEARCH AND PUBLICATION ETHICS 2021 - St Thomas College (Autonomous)", 10);
	    softassert.assertAll();
	}
	
	@Test(priority = 3, description = "Scroll to course section and play video", groups = {"regression"})
	public void verifyDirectorateOfResearchLink() {
		
	    WebElement scroll1 = driver.findElement(By.xpath("//strong[contains(text(),'Research and publication ethics course')]"));
	    act.scrollToElement(scroll1).perform();
	    SleepUtils.shortWait();

	    WebElement video = driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[2]/main[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/iframe[1]"));
	    act.moveToElement(video).click().perform();
	    SleepUtils.lengthyWait();
	    act.moveToElement(video).click().perform();
	    SleepUtils.shortWait();
	}

	@Test(priority = 4, description = "Loop through course-related links and return back", groups = {"regression"})
	public void verifyCircularsAndOrdersLink() {
	    String[] linkRedirect = {
	        "//a[contains(text(),'Inauguration')]",
	        "//a[contains(text(),'https://www.ugc.ac.in/pdfnews/9836633_Research-and')]",
	        "//a[contains(text(),'http://www.universityofcalicut.info/dor/index.php/')]",
	        "//a[contains(text(),'https://www.mgu.ac.in/uploads/2020/03/rpe.pdf')]",
	        "//a[contains(text(),'Calicut University Order')]",
	        "//a[contains(text(),'https://docs.google.com/forms/d/e/1FAIpQLSclSKKwYP')]",
	        "//a[contains(text(),'click here for UGC Guidelines')]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[2]/b[1]/a[1]"
	    };

	    for (String linkLoop : linkRedirect) {
	    	
	    	By linkLocator = By.xpath(linkLoop);
	    	
	    	WebElement linkScroll = driver.findElement(linkLocator);
	        act.scrollToElement(linkScroll).perform();	    	
	    	
	        WebElement link = wait.waitForElementToBeClickable(linkLocator, 10);
	        act.moveToElement(link).click().perform();
	        SleepUtils.mediumWait();
	        driver.navigate().back();
	        wait.waitForTitleIs("RESEARCH AND PUBLICATION ETHICS 2021 - St Thomas College (Autonomous)", 10);
	    }
	    js.executeScript("window.scrollTo(0,500)");
	}

}

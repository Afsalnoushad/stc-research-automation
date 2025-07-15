package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.utils.*;
import stthomas.stc_research_automation.base.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RacMembers extends BaseClass{
	
	
	@Test(priority = 1, description = "Click on Research Advisory Council Members link and verify title and URL", groups = {"smoke","regression"})
	public void navigateToResearchCouncilMembers() {
		
	    SoftAssert softassert = new SoftAssert();
	    By linkLocator = By.xpath("//span[contains(text(),'Research Advisory Council Members')]");

	    WebElement elementToScroll = driver.findElement(linkLocator);
	    act.scrollToElement(elementToScroll).perform();
    
	    WebElement councilLink = wait.waitForElementToBeClickable(linkLocator, 10);
	    act.moveToElement(councilLink).click().perform();

	    String actualTitle = driver.getTitle();
	    if (!actualTitle.equals("Research Advisory Council Members - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "RACMembers_TitleMismatch");
	    }
	    softassert.assertEquals(actualTitle, "Research Advisory Council Members - St Thomas College (Autonomous)", "Page title mismatch");

	    String currentUrl = driver.getCurrentUrl();
	    if (!currentUrl.contains("research-council-members")) {
	        ScreenshotUtils.takeScreenShot(driver, "RACMembers_URLMismatch");
	    }
	    softassert.assertTrue(currentUrl.contains("research-council-members"), "URL does not contain expected keyword");

	    softassert.assertAll();
	}


    @Test(priority = 2, description = "Scroll and verify elements", groups = {"regression"})
    public void scrollAndVerifyCouncilMembersContent() throws Exception {
    	SoftAssert softassert = new SoftAssert();
        String[] xpaths = {
            "//li[contains(text(),'Dr. Nicy Sebastian(Statistics)')]",
            "//strong[contains(text(),'RESEARCH ADVISORY COMMITTEE (RESEARCH CENTRES)')]",
            "//strong[contains(text(),'Research centre in Chemistry:')]",
            "//li[contains(text(),'Dr. Binoy C F (Expert from research centre)')]"
        };
        for (String scroll : xpaths) {
            WebElement link = driver.findElement(By.xpath(scroll));
            act.scrollToElement(link).perform();
            SleepUtils.mediumWait();
        }
        js.executeScript("window.scrollTo(0,0)");
        softassert.assertAll();
    }
	  

}

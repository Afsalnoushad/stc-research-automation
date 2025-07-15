package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.utils.*;
import stthomas.stc_research_automation.base.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResearchAdvisoryCommitte extends BaseClass{
	
	
	@Test(priority=1,description="Navigate to Research Advisory Committee and verify title/url", groups = {"smoke","regression"})
	  public void navigateToResearchAdvisoryCommittee(){
		  
		  SoftAssert softassert = new SoftAssert();
		  
		  By rACLocator = By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li[7]/a[1]/span[1]");
		  WebElement rAC = wait.waitForElementToBeClickable(rACLocator, 10);
		  act.moveToElement(rAC).click().perform();
		  
		  String committeeTitle = driver.getTitle();
		  if (!committeeTitle.equals("Research Advisory Committees - St Thomas College (Autonomous)")) {
		      ScreenshotUtils.takeScreenShot(driver, "Research_Advisory_Committee_Title_Mismatch");
		  }
		  softassert.assertEquals(committeeTitle,"Research Advisory Committees - St Thomas College (Autonomous)","Research Advisory Committee - Page title mismatch");
		  
		  String committeeUrl = driver.getCurrentUrl();
		  if (!committeeUrl.contains("research-advisory-committee")) {
		      ScreenshotUtils.takeScreenShot(driver, "Research_Advisory_Committee_URL_Mismatch");
		  }
		  softassert.assertTrue(committeeUrl.contains("research-advisory-committee"),"Did not navigate to Research Advisory Committee");
		  driver.navigate().back();
		  softassert.assertAll();
	  }
	  


}

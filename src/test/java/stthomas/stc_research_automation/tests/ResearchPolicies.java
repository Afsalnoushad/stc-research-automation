package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.base.BaseClass;
import stthomas.stc_research_automation.utils.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ResearchPolicies extends BaseClass{
	
	 
	@Test(priority=1, description="Navigate to Research Policies Page Title and URL", groups = {"smoke","regression"})
	public void verifyResearchPoliciesPage() throws Exception {
		
	    SoftAssert softassert = new SoftAssert();
	    
	    By researchPoliciesLoca = By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li[6]/a[1]/span[1]");
	    WebElement researchPolicies = wait.waitForElementToBeClickable(researchPoliciesLoca, 10);
	    act.moveToElement(researchPolicies).click().perform();
	    
	    String policyTitle = driver.getTitle();
	    if (!policyTitle.equals("Research Policies - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "Research_Policies_Title_Mismatch");
	    }
	    softassert.assertEquals(policyTitle, "Research Policies - St Thomas College (Autonomous)", "Research Policies - Page title mismatch");

	    String policyUrl = driver.getCurrentUrl();
	    if (!policyUrl.contains("research-policy")) {
	        ScreenshotUtils.takeScreenShot(driver, "Research_Policies_URL_Mismatch");
	    }
	    softassert.assertTrue(policyUrl.contains("research-policy"), "Did not navigate to Research Policies");

	    softassert.assertAll();
	}

	@Test(priority=2, description="Click All Research Policy Links", groups = {"regression"})
	public void clickResearchPolicyLinks() throws Exception {
	    String[] linkTexts = { 
	        "//span[contains(text(),'RESEARCH PROMOTION POLICY')]",
	        "//span[contains(text(),'PLAGIARISM CHECK POLICY')]",
	        "//span[contains(text(),'SANTHOME RESEARCH (SEED MONEY) GRANT POLICY')]",
	        "//span[contains(text(),'RESEARCH ETHICS POLICY')]",		
	        "//span[contains(text(),'CONSULTANCY POLICY')]"
	    };

	    for(String linkAction : linkTexts) {
	  
	            WebElement link = driver.findElement(By.xpath(linkAction));
	            link.click();
	            SleepUtils.mediumWait();
	            link.click();	
	            SleepUtils.shortWait();	
	            js.executeScript("window.scrollBy(0,75)");
	            SleepUtils.shortWait();
	        
	    }

	    js.executeScript("window.scrollTo(0,0)");
	}



}

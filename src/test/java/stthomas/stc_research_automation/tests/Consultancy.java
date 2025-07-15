package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.base.BaseClass;
import stthomas.stc_research_automation.utils.*;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Consultancy extends BaseClass{
	
	@Test(priority = 1, description = "Navigate to Consultancy Page and verify title/url", groups = {"smoke","regression"})
	public void navigateToConsultancy() {
	    SoftAssert softassert = new SoftAssert();
	    
	    By consultancyLocator = By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li[12]/a[1]/span[1]");
	    
	    WebElement consultancyScroll = driver.findElement(consultancyLocator);
	    act.scrollToElement(consultancyScroll).perform();
	    
	    WebElement consultancy = wait.waitForElementToBeClickable(consultancyLocator, 10);
	    act.moveToElement(consultancy).click().perform();

	    String consultancyTitle = driver.getTitle();
	    if (!consultancyTitle.equals("Consultancy - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "Consultancy_Title_Mismatch");
	    }
	    softassert.assertEquals(consultancyTitle, "Consultancy - St Thomas College (Autonomous)", "Consultancy - Page title mismatch");

	    String consultancyUrl = driver.getCurrentUrl();
	    if (!consultancyUrl.contains("consultancy")) {
	        ScreenshotUtils.takeScreenShot(driver, "Consultancy_URL_Mismatch");
	    }
	    softassert.assertTrue(consultancyUrl.contains("consultancy"), "Did not navigate to Consultancy section");

	    softassert.assertAll();
	    SleepUtils.shortWait();
	}


	@Test(priority = 2, description = "Click Consultancy Links and Handle Windows", groups = {"regression"})
	public void handleConsultancyDocuments() {
	    String mainWindow = driver.getWindowHandle();

	    WebElement applicationForm = driver.findElement(By.xpath("//span[contains(text(),'Consultancy Application Form')]"));
	    applicationForm.click();

	    WebElement consultancyPolicy = driver.findElement(By.xpath("//span[contains(text(),'Consultancy Policy')]"));
	    consultancyPolicy.click();

	    Set<String> allWindow = driver.getWindowHandles();
	    String url = "";
	    for (String windowHandle : allWindow) {
	        if (!windowHandle.equals(mainWindow)) {
	            driver.switchTo().window(windowHandle);
	            url = driver.getCurrentUrl();
	            if (url.contains("https://accounts.google.com/v3/signin")) {
	                driver.switchTo().window(windowHandle);
	                SleepUtils.mediumWait();
	                driver.close();
	            } else if (url.endsWith(".pdf")) {
	                driver.switchTo().window(windowHandle);
	                SleepUtils.mediumWait();
	                driver.close();
	            }
	        }
	    }
	    driver.switchTo().window(mainWindow);
	}


}

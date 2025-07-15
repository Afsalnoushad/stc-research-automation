package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.base.BaseClass;
import stthomas.stc_research_automation.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AnnualResearchReports extends BaseClass {

    @Test(priority = 1, description = "Navigate to Annual Research Report section and verify title/url", groups = {"smoke","regression"})
    public void navigateToAnnualResearchReportSection() {
        SoftAssert softassert = new SoftAssert();

        By annualReportLocator = By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li[15]/a[1]/span[1]");
        WebElement annualResearchReport = driver.findElement(annualReportLocator);
        act.scrollToElement(annualResearchReport).perform();

        annualResearchReport = wait.waitForElementToBeClickable(annualReportLocator, 10);
        act.moveToElement(annualResearchReport).click().perform();

        String reportTitle = driver.getTitle();
        if (!reportTitle.equals("Annual Research Reports - St Thomas College (Autonomous)")) {
            ScreenshotUtils.takeScreenShot(driver, "Annual_Research_Report_Title_Mismatch");
        }
        softassert.assertEquals(reportTitle, "Annual Research Reports - St Thomas College (Autonomous)", "Annual Research Reports - Page title mismatch");

        String reportUrl = driver.getCurrentUrl();
        if (!reportUrl.contains("annual-research-reports")) {
            ScreenshotUtils.takeScreenShot(driver, "Annual_Research_Report_URL_Mismatch");
        }
        softassert.assertTrue(reportUrl.contains("annual-research-reports"), "Did not navigate to Annual Research Reports page");

        softassert.assertAll();
    }

    @Test(priority = 2, description = "Open each Annual Research Report one by one and perform slideshow", groups = {"regression"})
    public void openAllAnnualResearchReports() {
        String[] xpathText = {
            "//span[contains(text(),'Annual Research Report 2022')]",
            "//span[contains(text(),'Annual Research Report 2021')]",
            "//span[contains(text(),'Annual Research Report 2020')]",
            "//span[contains(text(),'Annual Research Report 2019')]",
            "//span[contains(text(),'Annual Research Report 2018')]"
        };

        for (String clickAction : xpathText) {
            
            By reportLocator = By.xpath(clickAction);
            WebElement reportLinkScroll = driver.findElement(reportLocator);
            act.scrollToElement(reportLinkScroll).perform();

            WebElement reportLink = wait.waitForElementToBeClickable(reportLocator, 10);
            act.moveToElement(reportLink).click().perform();

            
            By fullscreenLocator = By.xpath("//body/div[19]/a[2]");
            WebElement fullscreen = wait.waitForElementToBeClickable(fullscreenLocator, 10);
            act.moveToElement(fullscreen).click().perform();

            
            By slideshowLocator = By.xpath("//body/div[19]/a[3]");
            WebElement slideshow = wait.waitForElementToBeClickable(slideshowLocator, 10);
            act.moveToElement(slideshow).click().perform();

            
            SleepUtils.longWait();

            
            By closeLocator = By.xpath("//body/div[19]/a[1]");
            WebElement close = wait.waitForElementToBeClickable(closeLocator, 10);
            act.moveToElement(close).click().perform();
        }

        js.executeScript("window.scrollTo(0,0)");
    }

   
}

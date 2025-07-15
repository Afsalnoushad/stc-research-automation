package stthomas.stc_research_automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stthomas.stc_research_automation.utils.*;
import stthomas.stc_research_automation.base.BaseClass;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class PhdRegulationsAndUo extends BaseClass{
	
	@Test(priority = 1, description = "Navigate to PHD regulations page and verify title/URL", groups = {"smoke","regression"})
	public void navigateToPhdRegPage() throws Exception {
	    SoftAssert softassert = new SoftAssert();

	    By phdRegLocator = By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/nav[1]/ul[1]/li[4]/a[1]/span[1]");
	    
	    WebElement phdRegScroll = driver.findElement(phdRegLocator);
	    act.scrollToElement(phdRegScroll).perform();

	    WebElement phdRegAndUO = wait.waitForElementToBeClickable(phdRegLocator, 10);
	    act.moveToElement(phdRegAndUO).click().perform();

	    wait.waitForTitleIs("PhD Regulations & UO's - St Thomas College (Autonomous)", 10);

	    String phdTitle = driver.getTitle();
	    if (!phdTitle.equals("PhD Regulations & UO's - St Thomas College (Autonomous)")) {
	        ScreenshotUtils.takeScreenShot(driver, "PHD_Regulations_Title_Mismatch");
	    }
	    softassert.assertEquals(phdTitle, "PhD Regulations & UO's - St Thomas College (Autonomous)", "Page title mismatch");

	    String phdUrl = driver.getCurrentUrl();
	    if (!phdUrl.contains("phd-admission")) {
	        ScreenshotUtils.takeScreenShot(driver, "PHD_Regulations_URL_Mismatch");
	    }
	    softassert.assertTrue(phdUrl.contains("phd-admission"), "URL does not contain 'phd-admission'");

	    softassert.assertAll();
	}


	@Test(priority = 2, description = "Verify link: Directorate of Admission", groups = {"regression"})
	public void verifyDirectorateOfAdmissionLink() {
	    String mainWindow = driver.getWindowHandle();
	    WebElement DOAUC = driver.findElement(By.xpath("//a[contains(text(),'Directorate of Admission, University of Calicut')]"));
	    DOAUC.click();

	    Set<String> allWindow = driver.getWindowHandles();
	    for (String windowHandle : allWindow) {
	        if (!windowHandle.equals(mainWindow)) {
	            driver.switchTo().window(windowHandle);
	            if (driver.getTitle().equals("Directorate of Admission - University of Calicut")) {
	            	SleepUtils.mediumWait();
	                driver.close();
	            }
	        }
	    }
	    driver.switchTo().window(mainWindow);
	}

	@Test(priority = 3, description = "Verify PHD important links - first set", groups = {"regression"})
	public void verifyImportantLinksSetOne() throws Exception {
	    String[] xpath = {
	        "//a[contains(text(),'University Grants Commission (Minimum Standards an')]",
	        "//a[contains(text(),'PhD Regulations 2023 with effect from 06.02.2024')]"
	    };

	    for (String clickAction : xpath) {
	        By locator = By.xpath(clickAction);

	        WebElement elementToScroll = driver.findElement(locator);
	        act.scrollToElement(elementToScroll).perform();
	        
	        WebElement link = wait.waitForElementToBeClickable(locator, 10);
	        act.moveToElement(link).click().perform();
	        
	        SleepUtils.mediumWait();
	        
	        driver.navigate().back();

	        wait.waitForTitleIs("PhD Regulations & UO's - St Thomas College (Autonomous)", 10);
	    }

	}

	@Test(priority = 4, description = "Verify PDF opening from table section 1", groups = {"regression"})
	public void verifyPdfOpeningTable1() {
	    String mainWindow = driver.getWindowHandle();
	    js.executeScript("window.scrollBy(0,400)");

	    driver.findElement(By.xpath("//tbody/tr[1]/td[1]/ul[1]/li[2]/strong[1]/a[1]")).click();
	    driver.findElement(By.xpath("//tbody/tr[2]/td[1]/ul[1]/li[1]/strong[1]/a[1]")).click();
	    driver.findElement(By.xpath("//tbody/tr[3]/td[1]/ul[1]/li[1]/strong[1]/a[1]")).click();
	    driver.findElement(By.xpath("//tbody/tr[4]/td[1]/ul[1]/li[1]/strong[1]/a[1]")).click();

	    Set<String> newWindow = driver.getWindowHandles();
	    for (String windowHandle : newWindow) {
	        if (!windowHandle.equals(mainWindow)) {
	            driver.switchTo().window(windowHandle);
	            SleepUtils.mediumWait();
	            String url = driver.getCurrentUrl();
	            if (url.endsWith(".pdf")) {
	                System.out.println("PDF found: " + url);
	                driver.close();
	            }
	        }
	    }
	    driver.switchTo().window(mainWindow);
	}

	@Test(priority = 5, description = "Verify clickable document links", groups = {"regression"})
	public void verifySecondLinkSet() throws Exception {
	    String[] linkRedirect = {
	        "//tbody/tr[5]/td[1]/ul[1]/li[1]/strong[1]/a[1]",
	        "//tbody/tr[6]/td[1]/ul[1]/li[1]/strong[1]/a[1]",
	        "//a[contains(text(),'U.O implermenting amendment to Clause 2.1 ( Eligib')]",
	        "//tbody/tr[8]/td[1]/ul[1]/li[1]/strong[1]/a[1]",
	        "//a[contains(text(),'Resolution to provide Part time Ph.D registration ')]",
	        "//a[contains(text(),'Amendment to Clause 2.8.2 (granting part time Ph.D')]"
	    };

	    for (String clickAction : linkRedirect) {
	    	
	        By Linklocator = By.xpath(clickAction);

	        WebElement elementToScroll = driver.findElement(Linklocator);
	        act.scrollToElement(elementToScroll).perform();

	        WebElement link = wait.waitForElementToBeClickable(Linklocator, 10);
	        act.moveToElement(link).click().perform();

	        SleepUtils.mediumWait();
	        
	        driver.navigate().back();

	        wait.waitForTitleIs("PhD Regulations & UO's - St Thomas College (Autonomous)", 10);
	    }

	}

	@Test(priority = 6, description = "Verify PDF opening from table section 2", groups = {"regression"})
	public void verifyPdfOpeningTable2() {
	    String mainWindow = driver.getWindowHandle();
	    js.executeScript("window.scrollBy(0,400)");

	    driver.findElement(By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/ul[2]/li[1]/a[1]")).click();
	    driver.findElement(By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/ul[2]/li[2]/a[1]")).click();
	    driver.findElement(By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/ul[2]/li[3]/a[1]")).click();
	    driver.findElement(By.xpath("//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/ul[2]/li[4]/a[1]")).click();

	    Set<String> newWindows = driver.getWindowHandles();
	    for (String windowHandle : newWindows) {
	        if (!windowHandle.equals(mainWindow)) {
	            driver.switchTo().window(windowHandle);
	            SleepUtils.shortWait();
	            String url = driver.getCurrentUrl();
	            if (url.endsWith(".pdf")) {
	                System.out.println("PDF found: " + url);
	                driver.close();
	            }
	        }
	    }
	    driver.switchTo().window(mainWindow);
	}

	@Test(priority = 7, description = "Verify clickable links - last set", groups = {"regression"})
	public void verifyRemainingLinks() throws Exception {
	    String[] linkRedirect = {
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/ul[2]/li[5]/a[1]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/ul[2]/li[6]/a[1]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/ul[2]/li[7]/a[1]",
	        "//a[contains(text(),'U.O_implermenting_amendment_to_Clause_2.1__Eligibi')]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/ul[3]/li[2]/a[1]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/ul[3]/li[3]/a[1]",
	        "//body/div[@id='boxed-wrapper']/div[@id='wrapper']/main[@id='main']/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/ul[3]/li[4]/a[1]",
	        "//a[contains(text(),'Circular- Course Work exemption')]",
	        "//a[contains(text(),'Amendment to Rules & Regulations 2016 dt 17-01-202')]",
	        "//a[contains(text(),'Amendment to Rules & Regulations 2016 dt 12-11-202')]",
	        "//a[contains(text(),'Amendment to Rules & Regulations 2016 dt 16-08-201')]",
	        "//a[contains(text(),'Circular-Co-guide exemption')]",
	        "//a[contains(text(),'UO 2852/2021/Admn dt 05-03-2021- Extension of the ')]",
	        "//a[contains(text(),'Circular- Appointment of Co-guide')]",
	        "//a[contains(text(),'Circular- Exemption from Course Work and PQE to th')]",
	        "//a[contains(text(),'Circular- Admission to PhD Programme(date of joini')]",
	        "//a[contains(text(),'Circular- Progress Report -Submission')]",
	        "//a[contains(text(),'Circular- Admission to Ph.D. Programme – Procedure')]",
	        "//a[contains(text(),'Circular- Recognition as Research Guide – furnishi')]",
	        "//a[contains(text(),'UO- Conversion of FT scholars to PT on FIP or gues')]",
	        "//a[contains(text(),'UO- extend facility for part time research for lib')]",
	        "//a[contains(text(),'UO- Bio- metric Punching of the Research Scholars ')]",
	        "//a[contains(text(),'UO- Norms for conduct of Ph.D. Open defence, Resea')]",
	        "//a[contains(text(),'UO- Re-registration/Revival of Defunct Ph.D. Regis')]",
	        "//a[contains(text(),'UO- Finalising the specific title of research by t')]"
	    };

	    for (String xpath : linkRedirect) {
	    	
	        By Linklocator = By.xpath(xpath);

	        WebElement elementToScroll = driver.findElement(Linklocator);
	        act.scrollToElement(elementToScroll).perform();

	        WebElement link = wait.waitForElementToBeClickable(Linklocator, 10);
	        act.moveToElement(link).click().perform();

	        SleepUtils.mediumWait();
	        
	        driver.navigate().back();

	        wait.waitForTitleIs("PhD Regulations & UO's - St Thomas College (Autonomous)", 10);
	    }
	}

 

}

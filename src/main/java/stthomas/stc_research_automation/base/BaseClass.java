package stthomas.stc_research_automation.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import stthomas.stc_research_automation.utils.WaitHelper;

public class BaseClass {
	
	protected WebDriver driver;
    protected Actions act;
    protected JavascriptExecutor js;
    protected WaitHelper wait;
    
    
    @BeforeClass(alwaysRun = true)
    public void setup() {
  	  WebDriverManager.chromedriver().setup();
  	  driver=new ChromeDriver();
  	  driver.get("https://stthomas.ac.in/about-research-council/");
  	  driver.manage().window().maximize();
  	  act=new Actions(driver);
	  js=(JavascriptExecutor)driver;
	  wait  = new WaitHelper(driver);
  	  
    }
    
    @AfterClass(alwaysRun = true)
    public void tearDown() {
    	if(driver!=null) {	
    	   driver.quit();
    	}

    }

}

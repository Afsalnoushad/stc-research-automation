package stthomas.stc_research_automation.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static void takeScreenShot(WebDriver driver,String fileName) {
		try {
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\afsal\\Downloads\\"+fileName+""+"_"+timestamp+".jpg");
			Files.copy(f1.toPath(), dest.toPath());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}

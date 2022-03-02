package cusca.utility;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cusca.brain.BasePage;


public class Screenshot extends BasePage {
	public Screenshot(WebDriver driver) {
		super(driver);
	}
	
	//Take screenshot
	public static String takeScreenshot(WebDriver driver, String methodName) {
		String fileName = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir")+"/screenshots/";
		new File(directory).mkdirs();
		String path = directory+fileName;
		try {
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("Screenshot stored at; "+path);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public static String getScreenshotName(String methodName) {
		Date date = new Date();
		String fileName = methodName+"_"+date.toString().replace(":", "_").replace(" ", "_")+".png";
		return fileName;
	}

}

package cusca.utility;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	private static ExtentReports extent;
	
	public static ExtentReports createInstance() {
		String fileName = getReportName();
		String directory = System.getProperty("user.dir")+"/reports/";
		new File(directory).mkdir();
		String path = directory + fileName;
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		htmlReporter = new ExtentHtmlReporter("./reports/Extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automatic Report");
		htmlReporter.config().setReportName("Automated testing");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.setSystemInfo("Test type", "Functional Testing");
		extent.setSystemInfo("Organization", "Th33ngi");
		extent.setSystemInfo("User", "Manuel Reyes");
		extent.setSystemInfo("Position", "QA Automation Engineer (SDET)");
		extent.attachReporter(htmlReporter);

		return extent;
	}
	
	public static String getReportName() {
		Date date = new Date();
		String fileName = "AutomationReport_"+date.toString().replace(":", "_").replace(" ", "_")+".png";
		return fileName;
	}
}

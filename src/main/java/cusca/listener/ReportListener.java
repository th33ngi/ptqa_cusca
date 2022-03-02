package cusca.listener;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import cusca.brain.BaseTest;
import cusca.utility.ExtentReport;
import cusca.utility.Screenshot;


public class ReportListener extends BaseTest implements ITestListener{
	
	private static ExtentReports extent = ExtentReport.createInstance();
	private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public synchronized void onStart(ITestContext context) {
		System.out.println("Test Suite started!");
	}
	
	public synchronized void onFinish(ITestContext context) {
		if(extent !=null) {
			extent.flush();
		}
	}
	
	public synchronized void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getTestClass().getName()+"::"+result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	public synchronized void onTestSuccess(ITestResult result) {
		
		extentTest.get().pass("<b><font color=green>"+"Test executed successfully"+"</font></b>");
		String path = Screenshot.takeScreenshot(driver, result.getMethod().getMethodName());
		try {
			extentTest.get().pass("<b><font color=green>"+
					"Screenshot of success"+ "</font></b>", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) {
			extentTest.get().pass("Test Passed, cannot attach screenshot");
		}
		String logText = "<b>Test Method "+result.getMethod().getMethodName()+" Successful</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().createNode(result.getMethod().getMethodName()).pass(markup);
	}
	
	public synchronized void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("<details><summary><b><font color=red>"+"Exception Occured"+"</font></b></summary>"+
		exceptionMessage.replaceAll(",","<br>")+"</details> \n");
		String path = Screenshot.takeScreenshot(driver, result.getMethod().getMethodName());
		try {
			extentTest.get().fail("<b><font color=red>"+
					"Screenshot of failure"+ "</font></b>", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) {
			extentTest.get().fail("Test Failed, cannot attach screenshot");
		}
		
		String logText = "<b>Test Method "+methodName+" Failed</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().createNode(result.getMethod().getMethodName()).fail(markup);
	}
	
	public synchronized void onTestSkipped(ITestResult result) {
		String logText = "<b>Test Method "+result.getMethod().getMethodName()+" Skipped</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.BLUE);
		extentTest.get().createNode(result.getMethod().getMethodName()).skip(markup);
	}
	
	public synchronized void onTestFailedButWithinSuccesPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccesPercentage for "+result.getMethod().getMethodName());
	}
}

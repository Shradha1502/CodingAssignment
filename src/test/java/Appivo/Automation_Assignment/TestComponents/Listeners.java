package Appivo.Automation_Assignment.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Appivo.Automation_Assignment.Resources.ExtentReporterNG;

public class Listeners  extends BaseTest implements ITestListener {
	
	ExtentTest test ;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	 public void onTestStart(ITestResult result) {
		    // not implemented
		 
		 test = extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		  }
	 
	 public void onTestSuccess(ITestResult result) {
		    // not implemented
		 extentTest.get().log(Status.PASS, "TestCase Passed");
		 
		  }
	 public  void onTestFailure(ITestResult result) {
		    // not implemented
		 
		 extentTest.get().fail(result.getThrowable());
		 String filePath = null;
		 
		 try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			filePath = getScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		  }
	 
	 public void onFinish(ITestContext context) {
		    // not implemented
		 extent.flush();
		  }

	

}

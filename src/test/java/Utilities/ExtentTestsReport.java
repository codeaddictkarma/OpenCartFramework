package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentTestsReport implements ITestListener {
	
	 public ExtentSparkReporter spark;
	 public ExtentReports extent;
	 public ExtentTest test;
	 public String reportPath = "C:\\Users\\psanj\\eclipse-workspace\\OpenCartFrameWorkProject\\TestsReport\\";  
	 public void configureReport() {
		 //write time stamp to report
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 String reportname = reportPath + "ExtentTestReport_" + timeStamp + ".html";
		 spark = new ExtentSparkReporter(reportname);
		 extent = new ExtentReports();
		 extent.attachReporter(spark);
		 extent.setSystemInfo("OS", "Windows");
		 extent.setSystemInfo("Host Name", "Local Host");
		 extent.setSystemInfo("Environment", "QA");
		 extent.setSystemInfo("User Name", "Test User");
		 extent.setSystemInfo("Browser", "Chrome");
		 extent.setSystemInfo("Website", "OpenCart");
		 
		 spark.config().setDocumentTitle("Extent Report");
		 spark.config().setReportName("This is my testcases report");
		 spark.config().setTheme(Theme.DARK);
		 
		 
		 
		 
		 //take all groups in string list 
		 //include groups in report 
		 
	 }
	 
	 public void onStart(ITestContext result) {
		 configureReport();
		 
	 }
	 public void onFinish(ITestContext result) {
		 extent.flush();
		 //close the repor
	 }
	 public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getMethod().getMethodName());
		 String[] Groups = result.getMethod().getGroups(); 
		 for(String group : Groups) {
			 test.assignCategory(group);  
		 }
	 }
	 
	 public void onTestSuccess(ITestResult result) {
		 test.pass("Test Passed");
		 test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case Passed", ExtentColor.GREEN));
	 }
	 
	 public void onTestFailure(ITestResult result) {
		 
		 test = extent.createTest(result.getMethod().getMethodName());
		 test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test Case Failed", ExtentColor.RED));
		 //taking screenshot of failed test case
//		 
//		 try {
//			 String imgpath = new BaseClass().captureScreen(result.getName());
//			 test.addScreenCaptureFromPath(imgpath);
//		 }
//		 catch (Exception e) {
//			// TODO: handle exception
//			 e.printStackTrace();
//		 }
		}
	 
	 
	 public void onTestSkipped(ITestResult result) {
		 test.skip("Test Skipped");
		 test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case Skipped", ExtentColor.YELLOW));
	 }
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 test.skip("Test Failed but within success percentage");
	 }
	// Implement the methods from ITestListener interface to generate reports
	// For example, you can use ExtentReports library to create detailed test reports
	// Initialize ExtentReports and ExtentTest objects here

	// Example:
	// ExtentReports extent;
	// ExtentTest test;

	// @Override
	// public void onStart(ITestContext context) {
	//     // Initialize ExtentReports and create a new report
	// }

	// @Override
	// public void onTestStart(ITestResult result) {
	//     // Create a new test in the report
	// }

	// @Override
	// public void onTestSuccess(ITestResult result) {
	//     // Log test success in the report
	// }

	// @Override
	// public void onTestFailure(ITestResult result) {
	//     // Log test failure in the report
	// }

	// @Override
	// public void onFinish(ITestContext context) {
	//     // Flush the report and close it
	// }
}

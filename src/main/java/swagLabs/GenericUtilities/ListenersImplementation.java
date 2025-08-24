package swagLabs.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("--------------------"+result.getMethod().getMethodName()+" Method execution Started--------------------");
		test = report.createTest(result.getMethod().getMethodName()+"Test");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("--------------------"+result.getMethod().getMethodName()+" Method execution Passed--------------------");
		test.log(Status.PASS, result.getMethod().getMethodName()+" Method is PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("--------------------"+result.getMethod().getMethodName()+" Method execution Failed--------------------");
		test.log(Status.FAIL, result.getMethod().getMethodName()+" Method is Failed");
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wb = new WebDriverUtility();
		String path = wb.captureScreenShot(BaseClass.sdriver, result.getMethod().getMethodName()+ju.getSystemDate());
		test.addScreenCaptureFromPath(path);
		test.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("--------------------"+result.getMethod().getMethodName()+" Method execution Skipped--------------------");
		test.log(Status.SKIP, result.getMethod().getMethodName()+" Method is Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("--------------------Suite execution started--------------------");
		
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReport\\extentReport "+new JavaUtility().getSystemDate()+".html");
		esr.config().setTheme(Theme.DARK);
		esr.config().setDocumentTitle("SwagLabs Automation Report");
		esr.config().setReportName("Automation Report");
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base URL", "Test Environment URL");
		report.setSystemInfo("ReporterName", "Saiteja");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("--------------------Suite execution Finished--------------------");
		report.flush();
	}

}

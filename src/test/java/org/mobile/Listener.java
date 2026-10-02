/**
 * 
 */
package org.mobile;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.utils.AndroidMobileGuestures;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

/**
 * 
 */
public class Listener extends BaseTest implements ITestListener

{
	ExtentTest test;
	ExtentReports extent = ReporterNG.getReport();
	AndroidDriver driver;
	@Override
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, "Test Passed");
	}
	
	/*
	 * @Override public void onTestFailure(ITestResult result) {
	 * test.log(Status.FAIL, "Test Failed"); test.fail(result.getThrowable()); try {
	 * driver= (AndroidDriver)
	 * result.getTestClass().getRealClass().getField("driver").get(result.
	 * getInstance()); } catch (IllegalArgumentException | IllegalAccessException |
	 * NoSuchFieldException | SecurityException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } try {
	 * test.addScreenCaptureFromPath(screenShotTaken(result.getMethod().
	 * getMethodName(), driver)); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 */
	
	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}

}

package com.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.utils.DriverUtils;

public class MyListener extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		//to initilize the ExtentTest 
		test=report.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "TestCase passed with name "+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Testcase failed with name "+result.getName());
	
		String path=DriverUtils.getScreenShot(result.getName());
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Testcase skipped with name "+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		reportInit();//from base class we are created this method
		
	}

	public void onFinish(ITestContext context) {
		report.flush();//it will add all the data in extent report
		
	}
	
	

}

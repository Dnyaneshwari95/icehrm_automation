package com.icehrm1_automation.utility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener,ISuiteListener{
	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("This is onStart of ISuite from TestListeners");
		String suiteName=suite.getName();
		System.out.println(suiteName);
	}
	
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("This is onFinish of ISuite from TestListeners");
	}
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("This is onStart of ITestContext from TestListeners");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("This is onFinish of ITestContext from TestListeners");
	}
 	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("This is onTestStart of ITestResult from TestListeners");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("This is onTestSuccess of ITestResult from TestListeners");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("This is onTestFailure of ITestResult from TestListeners");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("This is onTestSkipped of ITestResult from TestListeners");
		
	}
	
}

package com.satwa.testNg.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestNGListenerClass implements ITestListener {
	
	
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " is passed");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " is failed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+ " is skipped");
	}

}

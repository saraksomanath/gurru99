package com.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utility.UtilityMethods;

public class TestListener implements ITestListener {

	public void onTestStart(ITestResult result) {

		Reporter.log("onTestStart:----" + result.getName());

	}

	public void onTestSuccess(ITestResult result) {

		Reporter.log("onTestSuccess:--" + result.getName());

	}

	public void onTestFailure(ITestResult result, WebDriver driver) throws IOException {

		

		Reporter.log("Test CaseFailed:-----" + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

	}

}

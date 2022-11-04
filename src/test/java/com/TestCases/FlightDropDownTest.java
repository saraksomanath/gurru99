package com.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pages.FlightDropDown;

import utility.UtilityMethods;

@Listeners (TestListener.class)
public class FlightDropDownTest {

	WebDriver driver;

	FlightDropDown flightDropDown;

	@BeforeMethod
	public void launchBrowser() throws IOException {

		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumLibrary\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(UtilityMethods.getProperty("urlFlight"));
	}

	@Test
	public void getRoundtripTest() throws InterruptedException {

		flightDropDown = new FlightDropDown(driver);

		flightDropDown.setRoundtrip();
		flightDropDown.getRoundtrip().click();

		Thread.sleep(1000);

		flightDropDown.getRoundtrip().isSelected();

		Assert.assertTrue(flightDropDown.getRoundtrip().isSelected());

	}

	@Test
	public void oneWayTest() throws IOException {

		flightDropDown = new FlightDropDown(driver);

		flightDropDown.setOneway();
		flightDropDown.getOneway().click();

		flightDropDown.getOneway().isSelected(); // =>true/false

	//	UtilityMethods.screenShot(driver);
		
		Assert.assertTrue(flightDropDown.getOneway().isSelected()); 
		
	//	Assert.assertTrue(false);
		
	}
	
	@Test
	public void passengerDropDown() {
		
		flightDropDown = new FlightDropDown(driver);
		
		
		flightDropDown.setPassengers();
		flightDropDown.getPassengers().click();
		
		UtilityMethods.dropDown(flightDropDown.getPassengers());
	}
	
	@Test
	public void DepartingFromDropDown() {
		
		flightDropDown = new FlightDropDown(driver);
		
		flightDropDown.setFromPort();
		flightDropDown.getFromPort().click();
		
		UtilityMethods.dropDown(flightDropDown.getFromPort());
		
	}

	@AfterMethod
	public void tearMethod(ITestResult result) throws IOException {
		
		if (result.getStatus() == result.FAILURE) {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);

			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(SrcFile, new File("C:\\Users\\Somnath\\eclipse-workspace\\com.guru99\\ScreenShot\\"
					+ System.currentTimeMillis() + ".png"));
		}
		
		driver.quit();
	}

}

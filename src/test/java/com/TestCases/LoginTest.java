package com.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pages.LoginPage;

import utility.UtilityMethods;

@Listeners(TestListener.class)
public class LoginTest {

	WebDriver driver;

	LoginPage loginPage;

	@BeforeMethod
	public void launchBrowser() throws IOException {

		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumLibrary\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(UtilityMethods.getProperty("url"));
		}
	

	@Test(dataProvider="excelData" ,dataProviderClass=UtilityMethods.class)
	public void login(String userName,String passWord) throws InterruptedException {

		loginPage=new LoginPage(driver);
		
		loginPage.setUserName();
		loginPage.getUserName().sendKeys(userName);
		
		loginPage.setPassword();
		loginPage.getPassword().sendKeys(passWord);

		loginPage.setSubmitButton();
		loginPage.getSubmitButton().click();
		
		Thread.sleep(200);
		UtilityMethods.scroll(driver);
		Thread.sleep(200);
		
		
		
	}

	@AfterMethod
	public void tearMethod() {
		driver.quit();
	}
	
}

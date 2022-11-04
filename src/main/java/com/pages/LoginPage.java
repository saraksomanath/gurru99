package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	
public 	LoginPage(WebDriver driver){
		
		this.driver=driver;	
	}

WebElement userName;
WebElement password;
WebElement submitButton;

public WebElement getUserName() {
	return userName;
}
public void setUserName() {
	userName = driver.findElement(By.xpath("//input[@name='userName']"));
}
public WebElement getPassword() {
	return password;
}
public void setPassword() {
	password = driver.findElement(By.xpath("//input[@name='password']"));
}
public WebElement getSubmitButton() {
	return submitButton;
}
public void setSubmitButton() {
	submitButton  = driver.findElement(By.xpath("//input[@name='submit']"));
}



}

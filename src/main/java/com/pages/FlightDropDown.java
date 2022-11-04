package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightDropDown {

	WebDriver driver;

	public FlightDropDown(WebDriver driver) {

		this.driver = driver;
	}

	WebElement roundtrip;

	WebElement oneway;

	WebElement passengers;

	WebElement fromPort;

	public WebElement getRoundtrip() {
		return roundtrip;
	}

	public void setRoundtrip() {
		roundtrip = driver.findElement(By.xpath("//input[@value='roundtrip']"));
	}

	public WebElement getOneway() {
		return oneway;
	}

	public void setOneway() {
		oneway = driver.findElement(By.xpath("//input[@value='oneway']"));
	}

	public WebElement getPassengers() {
		return passengers;
	}

	public void setPassengers() {
		passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
	}

	public WebElement getFromPort() {
		return fromPort;
	}

	public void setFromPort() {
		fromPort = driver.findElement(By.xpath("//select[@name='fromPort']"));
	}


}

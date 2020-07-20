package com.kick_out.practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo {
	WebDriverManager().chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	

	

	@Test(dataProvider = "data")
	public void m1(int a) {
		
		System.out.println("method a value :"+ a);
	}
	
	@DataProvider
	public Object[][] data() {
		
		return new Object[][] {
			{110}
			};
	}
}

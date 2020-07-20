package com.kick_out.practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TrivagoDemo {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void teardown() {
			driver.quit();
	}
	
	@Test(dataProvider="getData")
	public void Test(String location, String checkin, String checkout, String rooms) {
			driver.get("https://www.trivago.in/");
			driver.findElement(By.id("querytext")).sendKeys(location);	
			driver.findElement(By.xpath("//div[@class='ssg-suggest']//ul//li[1]")).click();
			driver.findElement(By.xpath("//time[@datetime='"+checkin+"']")).click();
			driver.findElement(By.className("cal-btn-next")).click();
			driver.findElement(By.xpath("//div//table[@class='cal-month']//tbody"
					+ "//tr//td//time[@datetime ='"+checkout+"']")).click();
			driver.findElement(By.xpath("//span[text()='"+rooms+"']")).click();
	}
	
	@DataProvider()
	public Object[][] getData() {
		Object[][] searchdata = DataReader.dataTable("sheet1");
		return searchdata;
	}

}

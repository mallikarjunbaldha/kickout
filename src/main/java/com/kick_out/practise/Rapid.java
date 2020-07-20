package com.kick_out.practise;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rapid {
	WebDriver driver;
	WebDriverWait wait;
	FluentWait waite;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		waite = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(3, TimeUnit.SECONDS).ignoring(Exception.class))
		
	}
	public void takeScreenshot() throws IOException {
		TakesScreenshot ss = (TakesScreenshot)driver;
		File ssfile = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File("E:\\Selenium3.0\\kick_out\\screenshots\\screenshot1.jpeg");
		FileUtils.copyFile(ssfile, dest);
	}
	@Test(enabled= false)
	public void test() throws IOException {
		driver.get("https://www.google.com");
	}
	
	//select class
	@Test(enabled = false)
	public void selectTest() {
		driver.get("https://www.facebook.com");
		WebElement date = driver.findElement(By.id("day"));
		Select select = new Select(date);
		boolean b = select.isMultiple();
		System.out.println("is day multiselect: "+ b);
		select.selectByVisibleText("7");
		List<WebElement> options = select.getOptions();
		for(WebElement e : options) {
			System.out.println("the options are : "+e.getText());
		}
	}
	@Test(enabled = false)
	public void openNewTab() throws InterruptedException {
		driver.navigate().to("https://www.toolsqa.com/selenium-webdriver/mouse-hover-action/");
		Actions actions = new Actions(driver);
		WebElement button = driver.findElement(By.xpath("//span[text()='Tutorial']"));
		//button.click();
		//actions.contextClick(button);
		actions.moveToElement(button).perform();
		WebElement innerbutton=driver.findElement(By.xpath("//span[text()='Front-End Testing Automation']"));
		actions.moveToElement(innerbutton).perform();
		WebElement last = driver.findElement(By.xpath("//span[text()='Selenium in Java']"));
		last.click();
		Thread.sleep(5000);
	}
	
	@Test
	public void closePopUp() throws InterruptedException {
		driver.navigate().to("https://www.toolsqa.com/selenium-webdriver/mouse-hover-action/");
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		Thread.sleep(10000);
		String popup = null;
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext()) {
			 popup = it.next();
		}
		driver.switchTo().window(popup);
		driver.findElement(By.xpath("//img[@alt='Close']")).click();
		driver.switchTo().window(parent);
		Thread.sleep(5000);
		WebElement home = driver.findElement(By.xpath("//img[@class=' preload-me']"));
		Assert.assertTrue(home.isDisplayed(), "the pop up is not closed");
		
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
}

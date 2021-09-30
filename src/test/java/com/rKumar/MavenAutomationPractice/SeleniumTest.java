package com.rKumar.MavenAutomationPractice;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {
	
	@Test
	public void practicePage(){
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> table = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum =0;
		for(int i=0; i<table.size(); i++)
		{
			int vals = Integer.parseInt(table.get(i).getText());
			sum = sum + vals;
		}
		System.out.println(sum);
		
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, total);
		
		if(sum==total)
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
	}

}
//1359


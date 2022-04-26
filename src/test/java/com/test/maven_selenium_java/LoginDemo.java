package com.test.maven_selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemo {

	public static WebDriver driver = null;

	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);

		// open web app
		driver.get("https://www.amazon.co.uk/");

		// Amazon login
		driver.findElement(By.id("sp-cc-accept")).click();

		driver.findElement(By.id("nav-link-accountList")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);

		WebElement emailid = driver.findElement(By.id("ap_email"));
		emailid.clear();
		emailid.sendKeys("panchalpooja222@gmail.com");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);

		driver.findElement(By.id("continue")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);

		WebElement password = driver.findElement(By.id("ap_password"));
		password.clear();
		password.sendKeys("12345678");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);

		driver.close();
	}
}

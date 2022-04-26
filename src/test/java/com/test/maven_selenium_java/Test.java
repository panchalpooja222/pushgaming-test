package com.test.maven_selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {
	public static WebDriver driver = null;
	public static String baseURL = "http://localhost:3000/";

	public static void main(String args[]) throws InterruptedException {

		try {

			System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(baseURL);
			Thread.sleep(3000);

			WebElement canvas = driver.findElement(By.xpath("//body/canvas[1]"));
			Thread.sleep(3000);
			Dimension canvassize = canvas.getSize();
			int canvas_center_x = (int) (canvassize.getWidth());
			int canvas_center_y = (int) (canvassize.getHeight());
			int button_x = 100;
			int button_y = 100;

			for (int w = 1; w <= 8; w++) {
				for (int h = 1; h <= 6; h++) {
					System.out.println("button_data:" + button_x + ":" + button_y);
					new Actions(driver).moveToElement(canvas, button_x, button_y).click().perform();
					button_y = button_y + 100;
				}
				button_x = button_x + 100;
				button_y = 100;
			}
		} catch (Exception e) {
			System.out.println("Error:" + e);
		} finally {
			if (driver != null) {
				driver.quit();
				System.out.println("done");
			}
		}

	}
}

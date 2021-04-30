package com.herokuapp.theinternet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AutomatePage {

	@Test
	public void correctTests() {

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		String URL = "http://automationpractice.com/index.php";

		// Open URL and Maximize browser window
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		// Click on Sign in
		driver.findElement(By.linkText("Sign in")).click();
		// Login
		driver.findElement(By.id("email")).sendKeys("test1249@test.com");
		sleep(2500);
		driver.findElement(By.id("passwd")).sendKeys("PKR@PKR");
		sleep(2500);
		driver.findElement(By.id("SubmitLogin")).click();
		sleep(2500);
		// Click on Women
		driver.findElement(By.linkText("WOMEN")).click();
		sleep(2500);

		WebElement SecondImg = driver
				.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
		sleep(2500);
		WebElement MoreBtn = driver.findElement(
				By.xpath("/html/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul/li[2]/div[1]/div[2]/div[2]/a[2]"));
		sleep(2500);
		Actions actions = new Actions(driver);
		actions.moveToElement(SecondImg).moveToElement(MoreBtn).click().perform();
		sleep(2500);
		// Change quantity by 2
		driver.findElement(By.id("quantity_wanted")).clear();
		sleep(2500);
		driver.findElement(By.id("quantity_wanted")).sendKeys("2");
		sleep(2500);
		// Select size as L
		WebElement Sizedrpdwn = driver.findElement(By.xpath("//*[@id='group_1']"));
		Select oSelect = new Select(Sizedrpdwn);
		oSelect.selectByVisibleText("M");
		sleep(2500);

		// Select Color
		driver.findElement(By.id("color_11")).click();
		sleep(2500);
		// Click on add to cart
		driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();
		sleep(2500);
		// Click on proceed
		driver.findElement(By.xpath("/html//div[@id='layer_cart']//a[@title='Proceed to checkout']/span")).click();
		sleep(2500);
		// Checkout page Proceed
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
		sleep(2500);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();
		sleep(2500);
		// Agree terms&Conditions
		driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
		sleep(2500);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span")).click();

		// Click on Payby Check
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")).click();
		sleep(2500);
		// Confirm the order
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();
		sleep(2500);
		// Get Text
		String ConfirmationText = driver
				.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();
		sleep(2500);
		// Verify that Product is ordered
		if (ConfirmationText.contains("complete")) {
			System.out.println("Order Completed: Test Case Passed");
		} else {
			System.out.println("Order Not Successfull: Test Case Failed");
		}

	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
}

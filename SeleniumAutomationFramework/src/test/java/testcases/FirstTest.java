package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class FirstTest extends BaseTest {

	@Test
	public static void Logintest() throws InterruptedException {
		
		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();  // locators -- properties
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("email_field"))).sendKeys("huzaifahvictor785@gmail.com");
		driver.findElement(By.xpath(loc.getProperty("next_btn"))).click(); Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("pass_field"))).sendKeys("Testing@91");
		driver.findElement(By.xpath(loc.getProperty("login_next_btn"))).click();
		
		//logs
		System.out.println("Clicked successfully!");
	}
}

package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class FirstTest extends BaseTest {

	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="testdata")
	public static void Logintest(String username, String password) throws InterruptedException {
		
//		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();  // locators -- properties
		Thread.sleep(10000);
		driver.findElement(By.xpath(loc.getProperty("email_field"))).sendKeys(username);
//		driver.findElement(By.xpath(loc.getProperty("next_btn"))).click(); Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("pass_field"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("login_btn"))).click();
		
		//logs
		System.out.println("Clicked successfully!");
		
	}
	
//	@DataProvider(name="testdata")
//	public Object[][] tData() {
//		return new Object[][]
//		{
//			{"demo@lumenore.com","BjAAA!111aaa"},
//			{"fouzanj@lumenore.com","AAA!111aaa"}
//		};
//	}
}

package com.letKodeit.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		//System.setProperty("webdriver.manage.driver", "C:\\Program Files\\Selenium\\drivers");
		driver = Driver.getDriver(ConfigurationReader.getProperty("browser"));
		driver.get(ConfigurationReader.getProperty("url"));
		driver.manage().window().maximize();
	}
	//@AfterMethod()
	public void closeBrowser() {
		driver.close();
	}

	@AfterTest()
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}

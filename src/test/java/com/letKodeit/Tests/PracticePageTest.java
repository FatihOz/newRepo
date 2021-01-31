package com.letKodeit.Tests;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.letKodeit.Pages.HomePage;
import com.letKodeit.Pages.LoginPage;
import com.letKodeit.Pages.PracticePage;
import com.letKodeit.Utilities.BrowserUtils;
import com.letKodeit.Utilities.ConfigurationReader;
import com.letKodeit.Utilities.TestBase;

public class PracticePageTest extends TestBase {

	HomePage hp = new HomePage();
	PracticePage pp = new PracticePage();
	LoginPage lp = new LoginPage();
	public static Select select;

	@Test(priority = 0)
	public void positiveLoginTest() throws InterruptedException {

		hp.loginBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lp.userEmail.sendKeys(ConfigurationReader.getProperty("userEMail"));
		lp.userPassword.sendKeys(ConfigurationReader.getProperty("userPWD"));
		lp.loginBtn2.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String expectedResult = "One more step";
		String actualResult = lp.oneMoreStep.getText();
		System.out.println("Title on th e page : " + expectedResult + " " + actualResult);
		Assert.assertEquals(expectedResult, actualResult);

		System.out.println();
		System.out.println(
				"============================================  Test 1  ======================================");
	}

	@Test(priority = 2)
	public void negatifLoginTest() throws InterruptedException, IOException {

		hp.loginBtn.click();
		lp.userEmail.sendKeys(ConfigurationReader.getProperty("userEMail1"));
		BrowserUtils.waitFor(3);
		lp.userPassword.sendKeys(ConfigurationReader.getProperty("userPWD1"));
		BrowserUtils.waitFor(3);
		BrowserUtils.getScreenshot("InvalidLogin");
		lp.loginBtn2.click();
		// BrowserUtils.getScreenshot("InvalidLogin");

		String expectedResult = "Invalid email or password.";
		String actualREsult = lp.invalidLogin.getText();
		System.out.println(expectedResult + " " + actualREsult);
		Assert.assertEquals(expectedResult, actualREsult);

		System.out.println();
		System.out.println(
				"============================================  Test 3  ======================================");
	}

	@Test(priority = 1)
	public void verifyPracticeHomePage() throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		hp.practiceBtn.click();

		String expected = "Practice Page";
		String actual = pp.practiceHOMEPAGE.getText();

		System.out.println("The title is shown on the page : " + actual);
		Assert.assertEquals(actual, expected);

		System.out.println();
		System.out.println(
				"============================================  Test 2  ======================================");
	}

	@Test(priority = 3)
	public void selectMenuForCars() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		hp.practiceBtn.click();
		String expected = "Practice Page";
		String actual = pp.practiceHOMEPAGE.getText();
		System.out.println("User is on the " + actual);
		// Assert.assertEquals(actual, expected);

		select = new Select(pp.carsDropDown);
		List<WebElement> listOfCars = select.getOptions();
		System.out.println(select.isMultiple());
		System.out.println("Size of the Cars list : " + listOfCars.size());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		for (int i = 0; i < listOfCars.size(); i++) {
			System.out.println(listOfCars.get(i).getText());

			if (listOfCars.isEmpty()) {
				System.out.println("There is NO any Car listed!!!!");

			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			select.selectByVisibleText("Honda");

		}
		String ExpectedResult = "Honda";
		String ActualResult = select.getFirstSelectedOption().getText();
		System.out.println("Selected option : " + ActualResult);

		Assert.assertEquals(ExpectedResult, ActualResult);

		System.out.println();
		System.out.println(
				"============================================  Test 4  ======================================");
	}

	@Test(priority = 4)
	public void muiltipleSelectOptions() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		hp.practiceBtn.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		select = new Select(pp.multipleSelectOptions);

		List<WebElement> multiOp = select.getOptions();

		System.out.println("Is it multi-Selection ? : " + select.isMultiple());

		for (WebElement multiFruit : multiOp) {

			System.out.println("=======" + multiFruit.getText());

			if (select.isMultiple()) {

				select.selectByValue("apple");
				select.selectByValue("peach");
			}

		}
		List<WebElement> selectedOptions = select.getAllSelectedOptions();

		for (WebElement selectedOption : selectedOptions) {
			System.out.println("=========" + selectedOption.getText());
		}
		if (multiOp.containsAll(selectedOptions)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}

		System.out.println();
		System.out.println(
				"============================================  Test 5  ======================================");
	}

	@Test(priority = 5)
	public void radioBtnSelect() throws InterruptedException {

		hp.practiceBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> RadioBTN = pp.listRadio;
		System.out.println("Size by checked Boxes : " + RadioBTN.size());

		String radioSTR = "";

		for (int i = 0; i < RadioBTN.size(); i++) {

			radioSTR = RadioBTN.get(i).getAttribute("value");

			if (RadioBTN.get(i).isEnabled()) {
				if (radioSTR.equalsIgnoreCase("Benz")) {
					RadioBTN.get(i).click();
				}
				System.out.println("List of CheckBox : " + radioSTR);
			}
			if(RadioBTN.get(i).isSelected()) {
				System.out.println("Selected check box : "+RadioBTN.get(i).getAttribute("value"));
			}
		}
		
		Thread.sleep(3000);

		System.out.println();
		System.out.println(
				"============================================  Test 6  ======================================");

	}
}

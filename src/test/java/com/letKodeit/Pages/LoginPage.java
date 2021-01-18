package com.letKodeit.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.letKodeit.Utilities.Driver;

public class LoginPage {
	
	protected WebDriver driver;
	
	public LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath="//input[@id='user_email']")
	public WebElement userEmail;
	
	@FindBy(xpath="//input[@id='user_password']")
	public WebElement userPassword;
	
	@FindBy(xpath="//input[@value='Log In']")
	public WebElement loginBtn2;
	
	@FindBy(xpath="//h1[text()='One more step']")
	public WebElement oneMoreStep;
	
	@FindBy(xpath ="//div[@class='alert alert-danger']")
	public WebElement invalidLogin;
}

package com.letKodeit.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.letKodeit.Utilities.Driver;

public class HomePage {

	WebDriver driver;
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//a[@href='/pages/practice']")
    public WebElement practiceBtn;
    
    @FindBy(xpath = "//a[@class='navbar-link fedora-navbar-link']")
    public WebElement loginBtn;
}

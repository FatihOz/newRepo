package com.letKodeit.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.letKodeit.Utilities.*;
public class PracticePage {

	protected WebDriver driver;

	public PracticePage() {
		
		PageFactory.initElements(Driver.getDriver(), this);
	}


		@FindBy(xpath = "//div[@id='radio-btn-example']//label[1]")
		public WebElement radioBMW;

		@FindBy(xpath = "//div[@id='radio-btn-example']//label[2]")
		public WebElement radioBENZ;

		@FindBy(xpath = "//div[@id='radio-btn-example']//label[3]")
		public WebElement radioHONDA;

		@FindBy(xpath = "//div[@id='checkbox-example']//label[1]")
		public WebElement checkboxBMW;

		@FindBy(xpath = "//div[@id='checkbox-example']//label[2]")
		public WebElement checkboxBENZ;

		@FindBy(xpath = "//div[@id='checkbox-example']//label[3]")
		public WebElement checkboxHONDA;

		@FindBy(xpath = "//h1[text()='Practice Page']")
		public WebElement practiceHOMEPAGE;
		
		@FindBy(id="carselect")
		public WebElement carsDropDown;
		
		@FindBy(id="multiple-select-example")
		public WebElement multipleSelectOptions;
	
}

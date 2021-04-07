package com.pedidosya.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	WebDriver driver;
	public LoginPage (WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="email") WebElement txtEmail;
	@FindBy(id="password") WebElement txtPassword;
	@FindBy(id="lnkLogin") WebElement btnLogin;
	@FindBy(xpath = "//div[@id='selectCity_chosen']//a[@class='chosen-single']") WebElement selectCity;
	@FindBy(xpath = "//div[@id='selectCity_chosen']//input[@placeholder='Buscar ciudad...']") WebElement inputCity; 
	@FindBy(id = "login") WebElement confirmLogin;
	@FindBy(xpath = "//div[contains(text(),'Damian')]") WebElement userName;
	@FindBy(id= "address") WebElement addressInput;
	@FindBy(id= "search") WebElement searchButton;
	@FindBy(xpath = "//li[@class='active-result result-selected']") WebElement confirmCity;
	
	@FindBy (id = "confirm") WebElement confirmLocation;
	
	public void setUserName (String uname) {

		txtEmail.clear();
		txtEmail.sendKeys(uname);

	}

	public void setPassword (String pwd) {

		txtPassword.clear();
		txtPassword.sendKeys(pwd);

	}

	public void clickLogin () {

		btnLogin.click();
	}

	public void confirmLogin () {

		confirmLogin.click();
	}

	public void selectCity (String city) {

		selectCity.click();		
		inputCity.sendKeys(city + "\n");		
		
	}
	
	public void enterAddress (String address) {
		
		addressInput.sendKeys(address);
		System.out.println("Address entered");
	}
	
	public String getPageTitle () {		
		String pageTitle = driver.getTitle();
		return pageTitle;		
		
	}
	
	public String getUserName () {
		
		return userName.getText();
	}
	
	public void quickLogin() {
		
		driver.get("https://pedidosya.com.ar");
		btnLogin.click();
		driver.switchTo().frame( driver.findElement( By.xpath( "//body/div[@id='']/div[1]/div[1]/div[1]/iframe[1]" ) ) );
		txtEmail.sendKeys("damianpereira.mdq@gmail.com");
		txtPassword.sendKeys("Pereiradamian1!");
		
		confirmLogin.click();
	}
	
	public void searchRestaurant () {
		
		searchButton.click();
	}
	
	public void confirmPlace () {
		
		confirmLocation.click();
		
	}
	
	public void closeBrowser () {
		
		driver.close();
	}

}

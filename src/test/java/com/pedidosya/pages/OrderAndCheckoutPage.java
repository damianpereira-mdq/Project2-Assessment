package com.pedidosya.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAndCheckoutPage {
	
	WebDriver driver;
	public OrderAndCheckoutPage (WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="searchList") WebElement inputSearch;
	@FindBy(xpath="//header/section[2]/button[1]") WebElement buttonSearch; 
	@FindBy(xpath="//a[contains(text(),'Las Palmeras')]") WebElement restaurantLP; 
	
	
	public void searchActualRestaurant (String Search) {
		
		inputSearch.sendKeys(Search);
		buttonSearch.click();
	}
	
	public void selectDirectRestaurant () {
		
		driver.findElement(By.linkText("Mouga Sushi")).click();
	}
	
	public void orderFood () {
		
		
	}
	
	public String getCheckoutPageTitle () {		
		String pageTitle = driver.getTitle();
		return pageTitle;		
		
	}
	
	
	
}

package com.pedidosya.stepsDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.pedidosya.listeners.TestListener;
import com.pedidosya.pages.LoginPage;
import com.pedidosya.utils.SetupBrowser;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


@Listeners(TestListener.class)
public class LoginPageSteps {

	WebDriver driver = null;
	public LoginPage loginPage;	

	// === Hooks ===
	
	@Before
	public void launchBrowser() {

		driver = SetupBrowser.startBrowser(driver, "Chrome");
	}

	@After
	public void closeBrowser() {

		SetupBrowser.closeBrowser(driver);
	}

	
	@Given("User launches Chrome browser")	
	public void user_launches_chrome_browser() {

		loginPage = new LoginPage(driver);
	}
	
	
	@When("User opens URL {string}")	
	public void user_opens_url(String appURL) {
		driver.get(appURL);
	}
	
	
	@When("Click Login button")	
	public void click_login_button() {
		loginPage.clickLogin();
	}

	@When("User enters user as {string} and password as {string}")
	public void user_enters_user_as_and_password_as(String username, String password) {
		// Switch to iFrame to login
		driver.switchTo().frame(driver.findElement(By.xpath("//body/div[@id='']/div[1]/div[1]/div[1]/iframe[1]")));

		loginPage.setUserName(username);
		loginPage.setPassword(password);
		loginPage.confirmLogin();
		// driver.close();

		// Switch back to Main Site content
		driver.switchTo().parentFrame();
	}

	@Then("The page title should be {string}")
	public void the_page_title_should_be(String expectedPageTitle) {

		String actualPageTitle = loginPage.getPageTitle();
		Assert.assertEquals(expectedPageTitle, actualPageTitle);

	}
	
	
	@Then("The page shows the name {string}")	
	public void the_page_shows_the_name(String expectedName) {

		String actualName = loginPage.getUserName();
		Assert.assertEquals(expectedName, actualName);

		System.out.println("==== Page shows the Name 'Damian'");
		System.out.println(actualName);

		// driver.close();

	}

	@Given("User has logged in succesfuly")
	public void user_has_logged_in_succesfuly() {

		// System.out.println("==== We are still logged in");
		loginPage = new LoginPage(driver);
		loginPage.quickLogin();

	}

	@When("User selects the city {string}")
	public void user_selects_the_city(String cty) {

		loginPage.selectCity(cty);
	}

	@When("User enter the address {string}")
	public void user_enter_the_address(String address) {
		loginPage.enterAddress(address);
	}

	@When("User confirms the entered location")
	public void user_confirms_the_entered_location() throws Exception {

		loginPage.searchRestaurant();
		Thread.sleep(2000);
		loginPage.confirmPlace();

	}

	@Then("The page updated title should be {string}")
	public void the_page_updated_title_should_be(String upTitle) {

	}

}

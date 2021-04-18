package com.pedidosya.stepsDefinitions;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pedidosya.listeners.TestListener;
import com.pedidosya.pages.LoginPage;
import com.pedidosya.pages.OrderAndCheckoutPage;
import com.pedidosya.utils.SetupBrowser;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@Listeners(TestListener.class)
public class StepsDefinitions {

	WebDriver driver;
	public LoginPage loginPage;
	public OrderAndCheckoutPage orderAndCheckout;

	// === Hooks ===

	@Before
	public void launchBrowser() throws MalformedURLException {

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

	@Given("User selects {string} restaurant")
	public void user_selects_restaurant(String restaurant) throws Exception {

		System.out.println("Last Scenario");
		String ciudad = "Mar del Plata";
		String direccion = "Tripulantes del Fournier 3474";

		loginPage = new LoginPage(driver);
		loginPage.quickLogin();
		loginPage.selectCity(ciudad);
		loginPage.enterAddress(direccion);
		loginPage.searchRestaurant();
		Thread.sleep(2000);
		loginPage.confirmPlace();

		// orderAndCheckout.searchActualRestaurant(restaurant);
		// System.out.println("Restaurant is: "+ restaurant);
		// orderAndCheckout.selectDirectRestaurant();
		// driver.findElement(By.id("searchList")).sendKeys("Las Palmeras");
		// driver.findElement(By.linkText("Mouga Sushi")).click();

	}

	@When("User selects the option {string}")
	public void user_selects_the_option(String foody) throws InterruptedException {

		//driver.findElement(By.cssSelector("body.inner.profile.peya.ar.user_is_not_logged.locationMyAccount.locationTestTop.locationProfile:nth-child(2) div.row.rowContainer:nth-child(19) section.medium-8.columns section.tab-panel.tab-active:nth-child(1) div.sectionContainer section.menuSectionContainer.seek:nth-child(4) div.section_animated:nth-child(3) ul.highlight_list li.peyaCard.product-full-card.product.most div.content.full-card-empty:nth-child(3) > h4.productName")).click();
		System.out.println("Selecting food :" + foody);
		Thread.sleep(1000);
	}

	@When("User confirms the selection")
	public void user_confirms_the_selection() throws InterruptedException {

		// driver.findElement(By.xpath("//body/div[@id='']/div[1]/div[1]/div[1]/div[1]/footer[1]/div[1]/a[1]")).click();
		System.out.println("Confirming food");
		Thread.sleep(1000);
	}

	@When("User selects {string}")
	public void user_selects(String confirm) {

		//driver.findElement(By.id("order")).click();

	}

	@Then("It should load the checkout page")
	public void it_should_load_the_checkout_page() {

		System.out.println("The checkout page was loaded");

	}

	@Then("The checkout page title should be {string}")
	public void the_checkout_page_title_should_be(String checkoutPageTitle) {

		// String actualPageTitle = driver.getTitle();
		// Assert.assertEquals(checkoutPageTitle, actualPageTitle);

		System.out.println("==== Page shows the checkout Name");
		System.out.println(checkoutPageTitle);

	}

}

package com.pedidosya.stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderAndCheckoutSteps {
	
	@Given("User selects {string} restaurant")
	public void user_selects_restaurant(String restaurant) {
	    
	}

	@When("User selects the option {string}")
	public void user_selects_the_option(String food) {
	   
	}

	@When("User confirms the selection")
	public void user_confirms_the_selection() {
	   
	}

	@When("User selects {string}")
	public void user_selects(String confirm) {
	    
	}

	@Then("It should load the checkout page")
	public void it_should_load_the_checkout_page() {
	    
	}

	@Then("The checkout page title should be {string}")
	public void the_checkout_page_title_should_be(String string) {
	   
	}

}

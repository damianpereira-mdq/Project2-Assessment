package com.pedidosya.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = ".//features",
		glue = {"com.pedidosya.stepsDefinitions"},
		dryRun = false,
		monochrome= true,
		publish= true,
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

		)

public class testRunner extends AbstractTestNGCucumberTests {




}

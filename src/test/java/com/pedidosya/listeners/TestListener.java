package com.pedidosya.listeners;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener  {
	
	Logger logger;
	DateTimeFormatter dtf;

	@Override
	public void onTestStart(ITestResult result) {
		LocalDateTime datetime = LocalDateTime.now();		
		String cDate = dtf.format(datetime);		
		logger.writeLogs("Test started: "+cDate);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		LocalDateTime datetime = LocalDateTime.now();		
		String cDate = dtf.format(datetime);		
		logger.writeLogs("Test Passed: "+cDate);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		LocalDateTime datetime = LocalDateTime.now();		
		String cDate = dtf.format(datetime);		
		logger.writeLogs("Test Failed: "+cDate);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		LocalDateTime datetime = LocalDateTime.now();		
		String cDate = dtf.format(datetime);		
		logger.writeLogs("Test Skipped: "+cDate);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		logger = new Logger();
		logger.createLogger("testNG-logs");
		dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		LocalDateTime datetime = LocalDateTime.now();		
		String cDate = dtf.format(datetime);		
		logger.writeLogs("Suite started: "+cDate);
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		LocalDateTime datetime = LocalDateTime.now();		
		String cDate = dtf.format(datetime);		
		logger.writeLogs("Test ended: "+cDate);
		logger.closeLogs();
		
	}

}

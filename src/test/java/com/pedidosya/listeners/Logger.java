package com.pedidosya.listeners;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {

	FileWriter mylogs;

	public String createLogger(String logName) {

		try {

			mylogs = new FileWriter(logName+".txt");			
			this.mylogs = mylogs;

		} catch (IOException e) {
			return e.getMessage();
		}

		return "Success";
	}

	public String writeLogs(String logInput) {
		try {
			mylogs.write(logInput);
			mylogs.write(System.getProperty( "line.separator" ));
			
		} catch (IOException e) {
			return e.getMessage();
		}
		return "Success";
	}
	
	public String closeLogs() {
		try {
			mylogs.close();
		} catch (IOException e) {
			return e.getMessage();
		}
		return "Success";
	}

}

package de.elbelife.service;

import java.util.Random;


public class HelloWorldService implements HelloWorldServiceMBean {

	private String message;
	private int marketNumber;


	public String getMessage() {
		System.out.println("getMessage()=" + message);
		return message;
	}

	public void setMessage(String message) {
		System.out.println("setMessage(" + message + ")");
		this.message = message;
	}

	public int getMarketNumber() {
		int marketNumber = new Random().nextInt(100);
		System.out.println("MarketNumber(" + marketNumber + ")");
		return this.marketNumber;
	}

}
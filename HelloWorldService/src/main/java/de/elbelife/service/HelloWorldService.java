package de.elbelife.service;

import java.util.Random;

import de.elbelife.monitoring.Scheduler;

public class HelloWorldService implements HelloWorldServiceMBean {

	private String message;
	private int marketNumber;
	private long marketOfReceivedUpdates;
	private long eventOfReceivedUpdates;
	protected Scheduler monitorScheduler;

	public HelloWorldService() {
		monitorScheduler = new Scheduler("HelloWorld Monitor");
		monitorScheduler.addMonitoredProcess(this);
	}

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

	public long getMarketOfReceivedUpdates() {
		return this.marketOfReceivedUpdates;
	}

	public long getEventOfReceivedUpdates() {
		return this.eventOfReceivedUpdates;
	}

	public void resetStatistics() {
		this.marketOfReceivedUpdates = 0;
		this.eventOfReceivedUpdates = 0;

	}

}
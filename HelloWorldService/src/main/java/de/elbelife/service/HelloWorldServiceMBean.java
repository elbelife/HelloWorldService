package de.elbelife.service;

import de.elbelife.monitoring.MonitoredProcess;


public interface HelloWorldServiceMBean extends MonitoredProcess{

	String getMessage();

	void setMessage(String message);

	int getMarketNumber();

}
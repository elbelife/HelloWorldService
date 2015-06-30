package de.elbelife.monitoring;

public interface MonitoredProcess {

	long getMarketOfReceivedUpdates();

	long getEventOfReceivedUpdates();

	void resetStatistics();

}

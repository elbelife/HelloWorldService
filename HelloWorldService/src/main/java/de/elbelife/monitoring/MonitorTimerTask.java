package de.elbelife.monitoring;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonitorTimerTask extends TimerTask {

	private static final Logger LOG = LoggerFactory.getLogger(MonitorTimerTask.class);

	private MonitoredProcess process;
	private long marketOfReceivedUpdates;

	private long eventOfReceivedUpdates;

	public MonitorTimerTask(MonitoredProcess process) {
		this.process = process;
	}

	@Override
	public void run() {
		LOG.debug("Collecting data for process {}", process.getClass().getName());
		marketOfReceivedUpdates = process.getMarketOfReceivedUpdates();
		eventOfReceivedUpdates = process.getEventOfReceivedUpdates();
		process.resetStatistics();
	}

	public long getNumberOfReceivedUpdatesSinceLastCall() {
		return marketOfReceivedUpdates;
	}

	public long getEventOfReceivedUpdatesSinceLastCall() {
		return eventOfReceivedUpdates;
	}

}
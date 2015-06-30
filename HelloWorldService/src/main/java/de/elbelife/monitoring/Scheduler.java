package de.elbelife.monitoring;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

public class Scheduler {

	private static final int DEFAULT_INTERVAL_MS = 60000;

	private Map<String, MonitoredProcess> processes = new HashMap<String, MonitoredProcess>();
	private Timer timer;
	private int interval;

	public Scheduler(String name) {
		this(name, DEFAULT_INTERVAL_MS);
	}

	public Scheduler(String name, int interval) {
		timer = new Timer(name, true);
		this.interval = interval;
	}

	public void addMonitoredProcess(MonitoredProcess process) {
		MonitorTimerTask task = new MonitorTimerTask(process);
		processes.put(getClassName(process), process);

		timer.schedule(task, new Date(), interval);
	}

	public long getMarketUpdatesSinceLastCall(MonitoredProcess process) {
		String processName = getClassName(process);
		MonitoredProcess monitoredProcess = processes.get(processName);
		return (monitoredProcess == null) ? 0 : monitoredProcess
			.getMarketOfReceivedUpdates();
	}

	public long getEventUpdatesSinceLastCall(MonitoredProcess process) {
		String processName = getClassName(process);
		MonitoredProcess monitoredProcess = processes.get(processName);
		return (monitoredProcess == null) ? 0 : monitoredProcess
			.getEventOfReceivedUpdates();
	}

	private String getClassName(Object clazz) {
		return clazz.getClass().getSimpleName();
	}
}
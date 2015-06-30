package de.elbelife.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.elbelife.service.HelloWorldService;

public class HelloWorldServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static  final Logger LOG = LoggerFactory.getLogger(HelloWorldServlet.class); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LOG.info ("enter--doGet");
		super.doGet(req, resp);
		LOG.info ("exit--doGet");
	}

	@Override
	public void init() throws ServletException {
		
		LOG.info ("enter--init");
		
		super.init();
		ArrayList<MBeanServer> serverList = MBeanServerFactory.findMBeanServer(null);
		MBeanServer serverHelloWorld = (MBeanServer) serverList.get(0);
		final HelloWorldService helloWorldMBean = new HelloWorldService();
		ObjectName helloWorld = null;
		try {
			helloWorld = new ObjectName("jboss.jmx:name=HelloJMX");
			serverHelloWorld.registerMBean(helloWorldMBean, helloWorld);
		} catch (MalformedObjectNameException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (InstanceAlreadyExistsException e) {
			e.printStackTrace();
		} catch (MBeanRegistrationException e) {
			e.printStackTrace();
		} catch (NotCompliantMBeanException e) {
			e.printStackTrace();
		}

		LOG.info ("exit--init");
	}

}

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

import de.elbelife.service.HelloWorldService;

public class HelloWorldServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("enter--doGet");
		super.doGet(req, resp);
		System.out.println("exit--doGet");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("enter--init");
		super.init();
		ArrayList<MBeanServer> serverList = MBeanServerFactory.findMBeanServer(null);
		MBeanServer serverHelloWorld = (MBeanServer) serverList.get(0);
		final HelloWorldService helloWorldMBean = new HelloWorldService();
		ObjectName helloWorld = null;
		try {
			helloWorld = new ObjectName("jboss.jmx:name=HelloJMX");
			serverHelloWorld.registerMBean(helloWorldMBean, helloWorld);
		} catch (MalformedObjectNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstanceAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MBeanRegistrationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotCompliantMBeanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("exit--init");
	}

}

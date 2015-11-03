package test.jmx;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class Client {
	public static void main(String[] args) throws Exception {

		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://10.10.71.199:9999/jmxrmi");
		JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

		MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
//		ClientListener listener = new ClientListener();
		
		
		
		while(true) {
			Object obj = mbsc.getAttribute(new ObjectName("java.lang:type=OperatingSystem"), "ProcessCpuLoad");
			Object objName = mbsc.getAttribute(new ObjectName("java.lang:type=OperatingSystem"), "Name");
			CompositeDataSupport compositeDataSupport = (CompositeDataSupport) mbsc.getAttribute(new ObjectName("java.lang:type=Memory"), "HeapMemoryUsage");
			
			System.out.println(obj);
			System.out.println(objName);
			System.out.println(compositeDataSupport.get("used") + "/" + compositeDataSupport.get("max"));
			
			Thread.sleep(1000);
		}
		
		
//		System.out.println("\nDomains:");
//		String domains[] = mbsc.getDomains();
//		Arrays.sort(domains);
//		for (String domain : domains) {
//			System.out.println("\tDomain = " + domain);
//		}
//		
//		System.out.println("\nMBeanServer default domain = " + mbsc.getDefaultDomain());
//
//		System.out.println("\nMBean count = " +  mbsc.getMBeanCount());
//		System.out.println("\nQuery MBeanServer MBeans:");
//		Set<ObjectName> names = new TreeSet<ObjectName>(mbsc.queryNames(null, null));
//		for (ObjectName name : names) {
//			System.out.println("\tObjectName = " + name);
//		}
//		// *****************
//		ObjectName mbeanName = new ObjectName("test:type=JMXTestImpl");
//		JMXTestMBean mbeanProxy = JMX.newMBeanProxy(mbsc, mbeanName, JMXTestMBean.class, true);
//
//		System.out.println("\nAdd notification listener...");
//		mbsc.addNotificationListener(mbeanName, listener, null, null);
//
//		System.out.println("\nCacheSize = " + mbeanProxy.getCacheSize());
//
//		mbeanProxy.setCacheSize(150);
//
//		System.out.println("\nWaiting for notification...");
//		System.out.println("\nCacheSize = " + mbeanProxy.getCacheSize());
//		System.out.println("\nInvoke sayHello() in Hello MBean...");
//		mbeanProxy.sayHello();
//
//		System.out.println("\nInvoke add(2, 3) in Hello MBean...");
//		System.out.println("\nadd(2, 3) = " + mbeanProxy.add(2, 3));

		
		
//		jmxc.close();
	}
}

package test.jmx;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;

public class JMXTestMain {

	public static void main(String[] args) throws Exception {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName("test:type=JMXTestImpl");
		JMXTest mbean = new JMXTest();
		mbs.registerMBean(mbean, name);
		
		

		while(true) {
//			System.out.println(ManagementFactory.getMemoryMXBean().getHeapMemoryUsage());
//			System.out.println(ManagementFactory.getThreadMXBean().getThreadCount());
			Thread.sleep(1000);
		}
	}
}

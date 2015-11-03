package test.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class JMXTest extends NotificationBroadcasterSupport implements
		JMXTestMBean {
	private int iSize = 0;
	private String name = "Reginald";
	private boolean bFlag = false;
	private long sequenceNumber = 0;
	
	public void sayHello() {
		System.out.println("Go fxck youself.");
	}

	public int add(int x, int y) {
		return x + y;
	}

	public String getName() {
		return name;
	}

	public int getCacheSize() {
		return iSize;
	}

	public void setCacheSize(int size) {
		int oldSize = this.iSize;
        this.iSize = size;

        System.out.println("Cache size now " + this.iSize);

        Notification n = new AttributeChangeNotification(this,
                                sequenceNumber++, System.currentTimeMillis(),
                                "CacheSize changed", "CacheSize", "int",
                                oldSize, this.iSize);

        sendNotification(n);
	}

	public boolean isFlag() {
		bFlag = true;
		return bFlag;
	}

	public void setFlag(boolean b) {
		this.bFlag = b;
	}

	public void sjfsaf() {
		System.out.println("CC");
	}

	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		String[] types = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };

		String name = AttributeChangeNotification.class.getName();
		String description = "An attribute of this MBean has changed";
		MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);
		return new MBeanNotificationInfo[] { info };
	}
}
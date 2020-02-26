package test.thread;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadHit {
	private static Logger log;
	
	private static CacheInstance cache = CacheInstance.getInstance();
	private static final int COUNT = 100000;
	
	private ChannelMessageHandler getThread;
	private ChannelMessageHandler removeThread;
	
	private final ExecutorService executor = Executors.newFixedThreadPool(2);
	
	static {
		for(int i = 0 ; i < COUNT ; i++) {
			cache.put(i, i);
		}
	}
	
	private ThreadHit() {
		initLogger();
		
		initThread();
		
		start();
		
		executor.shutdown();
	}
	
	private void start() {
		for(int i = 0 ; i < COUNT ; i++) {
			log.info("{}", i);
			getThread.onMessage(i);
			removeThread.onMessage(i);
		}
	}
	
	private void initThread() {
		getThread = new GetThread();
		removeThread = new RemoveThread();
		
		executor.execute(getThread);
		executor.execute(removeThread);
	}
	
	private void initLogger() {
		Properties prop = System.getProperties();
		prop.setProperty("log4j.configurationFile", "./config/log4j2.xml");
		log = LoggerFactory.getLogger(ThreadHit.class);
	}

	public static void main(String[] args) {
		new ThreadHit();
	}
}

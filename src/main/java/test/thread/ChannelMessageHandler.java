package test.thread;

import java.util.concurrent.ConcurrentLinkedDeque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ChannelMessageHandler implements Runnable {
	protected static final Logger log = LoggerFactory.getLogger(ChannelMessageHandler.class);
	private final ConcurrentLinkedDeque<Integer> queue = new ConcurrentLinkedDeque<>();
	
	public void onMessage(int i) {
		queue.offer(i);
	}
	
	@Override
	public void run() {
		Integer message;
		while (!Thread.currentThread().isInterrupted()) {
			if((message = queue.poll())!=null) {
				try {
					processMessage(message);
				}catch(Exception e) {
					log.error("failed to process message",e);
				}
			}
		}	
	}
	
	public abstract void processMessage(int i);
}

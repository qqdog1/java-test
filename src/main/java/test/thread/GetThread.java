package test.thread;

public class GetThread extends ChannelMessageHandler {
	private CacheInstance cache = CacheInstance.getInstance();
	private int errorCount = 0;

	@Override
	public void processMessage(int i) {
		try {
			if(cache.contains(i) && cache.get(i) > 0) {
			}
		} catch (Exception e) {
			log.error("GG:{}", ++errorCount);
		}
	}
}

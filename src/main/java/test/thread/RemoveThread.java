package test.thread;

public class RemoveThread extends ChannelMessageHandler {

	private CacheInstance cache = CacheInstance.getInstance();
	
	@Override
	public void processMessage(int i) {
		cache.remove(i);
	}
}

package test.thread;

import java.util.HashMap;
import java.util.Map;

public class CacheInstance {
	private static CacheInstance instance = new CacheInstance();
	private static Map<Integer, Integer> map = new HashMap<>();
	
	public static CacheInstance getInstance() {
		return instance;
	}
	
	public void put(int key, int value) {
		map.put(key, value);
	}
	
	public int get(int key) throws NullPointerException {
		return map.get(key);
	}
	
	public boolean contains(int key) {
		return map.containsKey(key);
	}
	
	public void remove(int key) {
		map.remove(key);
	}
}

package test.json;

import java.util.Map;

public class OO {
	private String name;
	private Map<String, OO> map;
	
	public OO() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, OO> getMap() {
		return map;
	}
	public void setMap(Map<String, OO> map) {
		this.map = map;
	}
}

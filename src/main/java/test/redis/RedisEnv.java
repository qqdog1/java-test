package test.redis;

public enum RedisEnv {
	BTSE_TESTING("10.1.31.185:6379,10.1.31.185:6380,10.1.31.185:6381,10.1.31.185:6382,10.1.31.185:6383,10.1.31.185:6384"),
	BTSE_STAGING("10.1.30.185:6379,10.1.30.185:6380,10.1.30.185:6381"),
	BTSE_NS("10.1.34.151:6379,10.1.34.152:6379,10.1.34.153:6379,10.1.34.154:6379,10.1.34.155:6379,10.1.34.156:6379"),
	;
	
	private String ips;
	
	RedisEnv(String ips) {
		this.ips = ips;
	}
	
	public String getIps() {
		return ips;
	}
}

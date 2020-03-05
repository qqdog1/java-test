package test.redis;

public enum RedisEnv {
	BTSE_TESTING("10.1.31.185:6379,10.1.31.185:6380,10.1.31.185:6381"),
	BTSE_STAGING("10.1.30.185:6379,10.1.30.185:6380,10.1.30.185:6381"),
	;
	
	private String ips;
	
	RedisEnv(String ips) {
		this.ips = ips;
	}
	
	public String getIps() {
		return ips;
	}
}

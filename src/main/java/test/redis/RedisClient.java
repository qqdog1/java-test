package test.redis;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class RedisClient {
	private static Scanner scanner;
	private JedisCluster jedisCluster;
	private RedisEnv currentRedisEnv;
	
	private RedisClient() {
		
	}
	
	public void readCommand(String[] command) {
		switch (command[0]) {
		case "env":
			listEnv();
			break;
		case "connect":
			if(command.length > 1) {
				connect(command[1]);
			}
			break;
		case "current":
			currentEnv();
			break;
		case "keys":
			if(command.length > 1) {
				listKeys(command[1]);
			} else {
				listAllKeys();
			}
			break;
		
		case "exit":
			close();
			break;
		}
	}
	
	private void listEnv() {
		for(RedisEnv redisEnv : RedisEnv.values()) {
			System.out.println(redisEnv.name());
		}
	}
	
	private void connect(String env) {
		RedisEnv redisEnv = RedisEnv.valueOf(env);
		if(redisEnv == null) {
			System.out.println("Can't find this environment.");
		}
		
		Set<HostAndPort> nodes = new HashSet<>();
        for (String ipPort : redisEnv.getIps().split(",")) {
            String ip = ipPort.split(":")[0];
            String port = ipPort.split(":")[1];
            HostAndPort hostAndPort = new HostAndPort(ip, Integer.parseInt(port));
            nodes.add(hostAndPort);
        }

        currentRedisEnv = redisEnv;
        jedisCluster = new JedisCluster(nodes);
	}
	
	private void currentEnv() {
		if(currentRedisEnv != null) {
			System.out.println(currentRedisEnv);
		} else {
			System.out.println("no connection");
		}
	}
	
	private void listAllKeys() {
		Set<String> setKeys = getKeys("*");

        for (String key : setKeys) {
            System.out.println(key);
        }
	}
	
	private void listKeys(String pattern) {
		Set<String> setKeys = getKeys(pattern);
		for (String key : setKeys) {
            System.out.println(key);
        }
	}
	
	private Set<String> getKeys(String pattern) {
		Set<String> setKeys = new HashSet<>();
        Map<String, JedisPool> map = jedisCluster.getClusterNodes();
        for (String redisKey : map.keySet()) {
            JedisPool jedisPool = map.get(redisKey);
            Jedis jedis = jedisPool.getResource();
            Set<String> set = jedis.keys(pattern);
            setKeys.addAll(set);
        }
        return setKeys;
	}
	
	private void close() {
		scanner.close();
		System.exit(0);
	}
	
	public static void main(String[] s) {
		RedisClient client = new RedisClient();

        scanner = new Scanner(System.in);
        while (true) {
            String cmd = scanner.nextLine();
            client.readCommand(cmd.split(" "));
        }
	}
}

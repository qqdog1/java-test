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
		case "get":
			if(command.length > 1) {
				getData(command[1]);
			}
			break;
		case "set":
			if(command.length > 2) {
				setData(command[1], command[2]);
			}
			break;
		case "hget":
			if(command.length > 2) {
				getHashData(command[1], command[2]);
			}
			break;
		case "hgetall":
			if(command.length > 1) {
				getAllHashData(command[1]);
			}
			break;
		case "hset":
			if(command.length > 3) {
				setHashData(command[1], command[2], command[3]);
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
		RedisEnv redisEnv;
		try {
			redisEnv = RedisEnv.valueOf(env);
		} catch(IllegalArgumentException e) {
			System.out.println("Can't find this environment.");
			return;
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
	
	private void getData(String topic) {
		System.out.println(jedisCluster.get(topic));
	}
	
	private void setData(String topic, String value) {
		jedisCluster.set(topic, value);
	}
	
	private void getHashData(String topic, String key) {
		System.out.println(jedisCluster.hget(topic, key));
	}
	
	private void getAllHashData(String topic) {
		Map<String, String> map = jedisCluster.hgetAll(topic);
		for(String key : map.keySet()) {
			String value = map.get(key);
			System.out.println(key + ":" + value);
		}
	}
	
	private void setHashData(String topic, String key, String value) {
		jedisCluster.hset(topic, key, value);
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

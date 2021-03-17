package MQ;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MQPractice {
    private static JedisPool pool = null;
    static {
        InputStream in = MQPractice.class.getClassLoader().getResourceAsStream("redis.property");
        Properties prop = new Properties();
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxWaitMillis(Long.valueOf(prop.getProperty("redis.maxWait")));
        poolConfig.setMaxIdle(Integer.valueOf(prop.getProperty("redis.maxIdle")));
        poolConfig.setMinIdle(Integer.valueOf(prop.getProperty("redis.minIdle")));
        poolConfig.setMaxTotal(Integer.valueOf(prop.getProperty("redis.maxTotal")));
        pool = new JedisPool(poolConfig,prop.getProperty("redis.url"),Integer.valueOf(prop.getProperty("redis.port")));
    }
    public static Jedis getJedis(){
        return pool.getResource();
    }

    public static void main(String[] args) {
        Jedis j = getJedis();
        System.out.println(j);
    }






}

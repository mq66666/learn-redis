package MQ;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MQPractice {
    private static JedisPool pool = null;
    static{
        InputStream in = MQPractice.class.getResourceAsStream("redis.property");
        Properties prop = new Properties();
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}

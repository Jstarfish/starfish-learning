package priv.starfish.schedule.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

//@Configuration
public class JedisConfig extends CachingConfigurerSupport {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.database}")
    private int defaultDatabaseIndex;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.pool.max-active}")
    private int maxActive;

    @Value("${spring.redis.pool.max-wait}")
    private long maxWaitMillis;


//    @Bean
//    public JedisPool getJedisPool(){
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        //jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
//       // jedisPoolConfig.setMaxTotal(maxActive);
//        jedisPoolConfig.setMinIdle(minIdle);
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,password);
//        return jedisPool;
//    }
}

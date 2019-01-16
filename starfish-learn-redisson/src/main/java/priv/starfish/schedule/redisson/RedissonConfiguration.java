package priv.starfish.schedule.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: jiahaixin
 * @date: 2018/12/19 11:23
 * @description:
 */
@Configuration
@AutoConfigureAfter(value = {RedissonProperties.class})
public class RedissonConfiguration {

    @Autowired
    private RedissonProperties redissonProperties;

    /**
     * 单Redis节点模式
     */

    @Bean
    //@ConditionalOnProperty(value = "redisson.address")
    public RedissonClient singleServer() {
        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer().setAddress(redissonProperties.getAddress()).setPassword(redissonProperties.getPassword()).setDatabase(redissonProperties.getDatabase());

        //.setTimeout(redissonProperties.getTimeout())
        //.setDatabase(redissonProperties.getDatabase())
        //.setConnectionPoolSize(redissonProperties.getConnectionPoolSize())
        //.setConnectionMinimumIdleSize(redissonProperties.getConnectionMiniumIdleSize());
       /* if (StringUtils.isNotEmpty(redissonProperties.getPassword())) {
            serverConfig.setPassword(redissonProperties.getPassword());
        }*/
        return Redisson.create(config);

    }


    /**
     * 主从模式
     */
    /*@Bean
    @ConditionalOnProperty(value = "redisson.masterAddresses")
    public RedissonClient masterSlaveServers() {
        Config config = new Config();
        MasterSlaveServersConfig serversConfig = config.useMasterSlaveServers()
                //可以用"rediss://"来启用SSL连接
                .setMasterAddress("redis://127.0.0.1:6379")
                .addSlaveAddress("redis://127.0.0.1:6389", "redis://127.0.0.1:6332", "redis://127.0.0.1:6419")
                .addSlaveAddress("redis://127.0.0.1:6399");

        if (StringUtils.isNotEmpty(redissonProperties.getPassword())) {
            serversConfig.setPassword(redissonProperties.getPassword());
        }
        return Redisson.create(config);
    }*/

    /**
     *  集群模式
     */
   /* @Bean
    @ConditionalOnProperty(value = "redisson.masterAddresses")
    public RedissonClient clusterServers() {
        Config config = new Config();
        ClusterServersConfig serverConfig = config.useClusterServers().addNodeAddress(redissonProperties.getMasterAddresses())
                .setTimeout(redissonProperties.getTimeout())
                //设置集群扫描时间
                .setScanInterval(redissonProperties.getScanInterval())
                //主节点线程池数量
                .setMasterConnectionPoolSize(redissonProperties.getMasterConnectionPoolSize())
                //从节点线程池数量
                .setSlaveConnectionPoolSize(redissonProperties.getSlaveConnectionPoolSize());

        if (StringUtils.isNotEmpty(redissonProperties.getPassword())) {
            serverConfig.setPassword(redissonProperties.getPassword());
        }
        return Redisson.create(config);
    }*/

    /**
     * 哨兵模式
     */
    /*@Bean
    @ConditionalOnProperty(value = "redisson.masterAddresses")
    public RedissonClient sentinelServers() {
        Config config = new Config();
        SentinelServersConfig serversConfig = config.useSentinelServers()
                .setMasterName("mymaster")
                //可以用"rediss://"来启用SSL连接
                .addSentinelAddress("127.0.0.1:26389", "127.0.0.1:26379")
                .addSentinelAddress("127.0.0.1:26319");

        if (StringUtils.isNotEmpty(redissonProperties.getPassword())) {
            serversConfig.setPassword(redissonProperties.getPassword());
        }
        return Redisson.create(config);
    }*/


}

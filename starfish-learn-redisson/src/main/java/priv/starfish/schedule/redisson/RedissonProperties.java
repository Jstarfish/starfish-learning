package priv.starfish.schedule.redisson;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: jiahaixin
 * @date: 2018/12/19 10:46
 * @description:
 */
@ConfigurationProperties(prefix = "single")
@Getter
@Setter
public class RedissonProperties {



    private String address;
    private String password;
    private int database;

    //private String clientName;
    //毫秒
   /* private int timeout=30000;

    private String sentinelAddress;
    private int connectionPoolSize=150;
    private int connectionMiniumIdleSize=10;
    private int slaveConnectionPoolSize=300;
    private int masterConnectionPoolSize=300;
    private String[] sentinelAddresses;
    private String[] masterAddresses;
    //毫秒
    private int scanInterval=2000;
    private String masterName;*/


}

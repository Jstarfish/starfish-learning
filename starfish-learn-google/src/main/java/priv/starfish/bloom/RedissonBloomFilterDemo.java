package priv.starfish.bloom;

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @description: Redisson 布隆过滤器
 * @author: starfish
 * @create: 2020-04-28 17:13
 **/
public class RedissonBloomFilterDemo {


    public static void main(String[] args) {

        // config.useSingleServer().setAddress("10.202.253.240:6379");
        Config config = new Config();
        //config.useSingleServer().setAddress("redis://10.202.253.240:6379");
        config.useSingleServer().setAddress("redis://0ae0454e5c582415@10.143.153.107:5785").setPassword("0ae0454e5c582415");
        RedissonClient redisson = Redisson.create(config);

        RBloomFilter<String> bloomFilter = redisson.getBloomFilter("user");
        // 初始化布隆过滤器，预计统计元素数量为55000000，期望误差率为0.03
        bloomFilter.tryInit(55000000L, 0.03);
        bloomFilter.add("Tom");
        bloomFilter.add("Jack");
        System.out.println(bloomFilter.count());   //2
        System.out.println(bloomFilter.contains("Tom"));  //true
        System.out.println(bloomFilter.contains("Linda"));  //false
    }

}

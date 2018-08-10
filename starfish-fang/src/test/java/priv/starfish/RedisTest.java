package priv.starfish;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @Auther: jiahaixin
 * @Date: 2018/8/10 17:39
 * @Description:
 */
public class RedisTest {

    private Jedis jedis;

    @Before
    public void connect() {
        jedis = new Jedis("39.105.124.247", 6379); // 默认端口是6379,也可以不写
        System.out.println("Service is running ---" + jedis.ping());
    }

    /*
     * 测试5+1(五大数据类型和key)
     */

    @Test
    public void testString() {
        jedis.set("name", "starfish");
        jedis.mset("age", "25", "isHandsome", "sure", "job", "programmer");
        jedis.incr("age");
        jedis.append("car", "CRV");
        System.out.println(
                jedis.get("age") + " years old " + jedis.get("name") + " is handsome? " + jedis.get("isHandsome"));
        System.out.println(jedis.mget("job", "car")); // 返回所有给定的key的值，返回数组
    }

    @Test
    public void testList() {
        jedis.del("language");
        jedis.lpush("language", "Chinese"); // 插入到表头，left 左边么
        jedis.rpush("language", "Japanese"); // 插入到表尾
        jedis.lpush("language", "English");
        jedis.lset("language", 0, "French"); // 将列表language下标是0的元素值设为French
        System.out.println(jedis.llen("language")); // 返回列表key的长度
        System.out.println(jedis.lrange("language", 0, 2)); // 返回列表中指定区间的元素
        System.out.println(jedis.lindex("language", 1)); // 返回下标为1的元素
    }

    @Test
    public void testHash() {
        // 添加数据
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "starfish");
        map.put("age", "25");
        map.put("car", "CRV");
        jedis.hset("user", "job", "programmer");
        jedis.hmset("user", map);
        String name = jedis.hget("user", "name");
        System.out.println("name:" + name);
        List<String> userInfo = jedis.hmget("user", "name", "age", "job", "car");
        System.out.println("userInfo:" + userInfo); // 返回给定域的值
        System.out.println(jedis.hlen("user"));
        System.out.println(jedis.hvals("user")); // 返回哈希表 key 中所有域的值
        System.out.println(jedis.hkeys("user")); // 返回hash表key中的所有域
        Iterator<String> iter = jedis.hkeys("user").iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + jedis.hmget("user", key));
        }
    }

    @Test
    public void testSet() {
        jedis.sadd("java", "myBatis", "Spring", "Struts", "Hibernate","python");
        System.out.println(jedis.scard("java"));
        jedis.srem("java", "python");  //移除key中的一个或多个元素
        System.out.println(jedis.sdiff("java"));
        System.out.println(jedis.sismember("java", "c++")); //判断C++是否在java集合中

        //redis还提供了一种有序集合
        jedis.zadd("DB", 1, "mysql");
        jedis.zadd("DB", 3, "sqlServer");
        jedis.zadd("DB", 0, "oracle");
        System.out.println("有序集长度："+jedis.zcard("DB"));  //返回有序集 key 的基数
        Set<String> set = jedis.zrange("DB", 0, 2);
        System.out.println(set);
        for (Iterator iterator = set.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            System.out.println(string);
        }
        System.out.println(jedis.zscan("DB", "0"));
    }

}

package priv.starfish.proxypattern.dynamicproperties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

import static priv.starfish.proxypattern.dynamicproperties.ReflectUtils.getTarget;

/**
 * @author: jiahaixin
 * @date: 2019/6/21 14:41
 * @description:
 */
public class Client {

    public static void main(String[] args) throws JsonProcessingException {
        UserEntityDemo entity = UserEntityDemo.builder().userId("123").userName("狗子").age(18).build();

        System.out.println("add properties before:" + entity.toString());

        Map<String, Object> properties = Maps.newHashMap();
        properties.put("address", "浙江杭州");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(getTarget(entity, properties));
        System.out.println(json);
    }
}

package strategy;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * @description:
 * @author: starfish
 * @date: 2021/4/16 16:02
 */
public class ConcreteStrategyB implements Strategy {
    @Override
    public void operate() {
        //具体的算法实现
        System.out.println("ConcreteStrategyB operate");
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("10023");
        System.out.println(list);
        System.out.println(StringUtils.join(list,","));


        Map<String, Long> groupMap = new HashMap<>();
        for (String groupName : groupMap.keySet()) {
            Long groupId = groupMap.get(groupName);
            System.out.println(groupId+"  ==");
        }
    }
}

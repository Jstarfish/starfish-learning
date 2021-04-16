package list;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: starfish
 * @date: 2021/2/24 11:47
 */
public class ListDemo {

    private static Logger logger = Logger.getGlobal();


    public static void main(String[] args) {

        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        b.add("bbb");
        System.out.println(a.contains(b));


        list();
    }
    public static void list() {
        List<User> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        User user1 = new User();
        user1.setRealName("汪1");
        user1.setPhone("1");
        user1.setAge(11);
        list1.add(user1);

        User user2 = new User();
        user2.setRealName("汪2");
        user2.setPhone("2");
        user1.setAge(22);
        list1.add(user2);

        User user3 = new User();
        user3.setRealName("汪3");
        user3.setPhone("3");
        list1.add(user3);

        User user4 = new User();
        user4.setRealName("汪4");
        user4.setPhone("4");
        list1.add(user4);

        List<User> users = list1.stream().filter(User -> "22".equals(User.getAge())).collect(Collectors.toList());
        users.stream().forEach(user -> {
            System.out.println(user.getRealName());
        });

        list1.stream().forEach(user -> {
            logger.info("list1元素遍历：" + user.getRealName());
        });

        //把user的realName全部拉出来存放到list2中
        list2 = list1.stream().map(user -> {
            return user.getRealName();
        }).collect(Collectors.toList());

        logger.info(list2.toString());
        list2.stream().forEach(ss -> {
            logger.info("list2遍历：" + ss);
        });
    }
}

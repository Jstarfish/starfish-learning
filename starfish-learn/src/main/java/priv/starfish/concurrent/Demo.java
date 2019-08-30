package priv.starfish.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: jiahaixin
 * @date: 2019/8/7 18:48
 * @description:
 */
public class Demo {


    public static void main(String[] args) {

        User user1 = new User();
        user1.userId = 1;
        user1.userName = "aa";
        User user2 = new User();
        user2.userId = 2;
        user2.userName = "bb";
        User user3 = new User();
        user3.userId = 3;
        user3.userName = "cc";
        User user4 = new User();
        user4.userId = 1;
        user4.userName = "dd";
        User user5 = new User();
        user5.userId = 5;
        user5.userName = "ee";

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        handleList(users,1);


        for (User user : users) {
            System.out.println("~~~~~~"+user.userId+"~~~~~~~~~~~~~"+user.userName);
        }

    }

    static class User{
        public int userId;
        public String userName;
    }


    public static void handleList(List<User> list, final int flag){
        // 开始时间
        long start = System.currentTimeMillis();

        // 每500条数据开启一条线程
        int threadSize = 500;
        int dataSize = list.size();
        int threadNum = dataSize / threadSize + 1;

        // 定义标记,过滤threadNum为整数
        boolean special = dataSize % threadSize == 0;

        ExecutorService exec = Executors.newFixedThreadPool(threadNum);
        // 定义一个任务集合
        List<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();

        Callable<Integer> task = null;
        List<User> cutList = null;
        try {
            // 确定每条线程的数据
            for (int i = 0; i < threadNum; i++) {
                if (i == threadNum - 1) {
                    if (special) {
                        break;
                    }
                    cutList = list.subList(threadSize * i, dataSize);
                } else {
                    cutList = list.subList(threadSize * i, threadSize * (i + 1));
                }
                final List<User> listStr = cutList;
                task = new Callable<Integer>() {

                    @Override
                    public Integer call() throws Exception {
                        for (User user : listStr) {

                            if(user.userId == 1){
                                user.userId=11;
                                System.out.println("==="+flag);
                            }

                        }
                        System.out.println(Thread.currentThread().getName() + " Handler Thread：" + listStr.size());
                        return listStr.get(1).userId;
                    }
                };
                // 这里提交的任务容器列表和返回的Future列表存在顺序对应的关系
                tasks.add(task);
            }

            List<Future<Integer>> results = exec.invokeAll(tasks);
            for (Future<Integer> future : results) {
                System.out.println(future.get());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        // 关闭线程池
        finally {
            exec.shutdown();
            System.out.println("handle thread took:" + (System.currentTimeMillis() - start) + "millisecond");
        }

    }
}

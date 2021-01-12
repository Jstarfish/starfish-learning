package priv.starfish.rmi.client;

import priv.starfish.rmi.shared.WorldClock;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: starfish
 * @Date: 2021/1/12 10:36
 */
public class Client {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        //连接到服务器localhost:1099
        Registry registry = LocateRegistry.getRegistry("localhost",1099);
        //查找名为"WorldClock"的服务器并强制转型为WorkClock接口
        WorldClock worldClock = (WorldClock) registry.lookup("WorldClock");
        //正常调用接口方法
        LocalDateTime now = worldClock.getLocalDateTime("UTC+8");
        System.out.println(now);
    }
}

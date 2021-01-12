package priv.starfish.rmi.server;

import priv.starfish.rmi.shared.WorldClock;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Description:
 * @Author: starfish
 * @Date: 2021/1/12 10:27
 */
public class Server {

    /**
     * 通过RMI提供的相关类，将我们自己的WorldClock实例注册到RMI服务上。
     * RMI的默认端口是1099，最后一步注册服务时通过rebind()指定服务名称为"WorldClock"。
     * @param args
     * @throws RemoteException
     */
    public static void main(String[] args) throws RemoteException {
        System.out.println("create world clock remote service...");
        //实例化一个worldClock
        WorldClock worldClock = new WorldClockService();
        //将此服务转换为远程服务接口
        WorldClock skeleton = (WorldClock) UnicastRemoteObject.exportObject(worldClock,0);
        //将RMI服务注册到1099端口
        Registry registry = LocateRegistry.createRegistry(1099);
        //注册此服务，服务名为"worlsclock"
        registry.rebind("WorldClock",skeleton);
    }
}

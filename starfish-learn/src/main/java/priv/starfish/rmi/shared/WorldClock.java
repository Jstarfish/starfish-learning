package priv.starfish.rmi.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: starfish
 * @Date: 2021/1/12 10:22
 */
public interface WorldClock extends Remote {

    /**
     * 获取指定区域时间
     * @param zoneId
     * @return
     * @throws RemoteException
     */
    LocalDateTime getLocalDateTime(String zoneId) throws RemoteException;
}

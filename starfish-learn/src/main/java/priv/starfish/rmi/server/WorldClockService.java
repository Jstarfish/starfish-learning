package priv.starfish.rmi.server;

import priv.starfish.rmi.shared.WorldClock;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @Description:
 * @Author: starfish
 * @Date: 2021/1/12 10:21
 */
public class WorldClockService implements WorldClock {
    @Override
    public LocalDateTime getLocalDateTime(String zoneId) throws RemoteException {
        return LocalDateTime.now(ZoneId.of(zoneId)).withNano(0);
    }
}

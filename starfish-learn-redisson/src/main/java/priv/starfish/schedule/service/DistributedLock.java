package priv.starfish.schedule.service;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @author: jiahaixin
 * @date: 2018/12/19 11:30
 * @description:
 */
public interface DistributedLock {

    RLock lock(String lockKey);

    RLock lock(String lockKey, int timeout);

    RLock lock(String lockKey, TimeUnit unit, int timeout);

    boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime);

    void unlock(String lockKey);

    void unlock(RLock lock);
}

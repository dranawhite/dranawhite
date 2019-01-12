package com.dranawhite.common.cache;

import com.dranawhite.common.exception.ResultCodeEnum;
import com.dranawhite.common.exception.business.DranaIllegalStateException;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;
import lombok.Setter;

/**
 * 定时重刷缓存
 *
 * @author dranawhite
 * @version $Id: AbstractScheduledCache.java, v 0.1 2019-01-12 11:13 dranawhite Exp $$
 */
public abstract class AbstractScheduledCache<K, V> implements IScheduledCache<K, V>, InitializingBean, DisposableBean {

    private ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);

    private Task task = new Task();

    private static final AtomicInteger serialNumber = new AtomicInteger(0);

    private static final long DEFAULT_DELAY_SECOND = 0;

    private static final long DEFAULT_PERIOD_SECOND = 10000;

    @Setter
    @Getter
    private long delaySeconds = DEFAULT_DELAY_SECOND;

    @Setter
    @Getter
    private long periodSeconds = DEFAULT_PERIOD_SECOND;

    @Override
    public void cache(K key, V value) {
        CacheUtils.cacheObject(key, value);
    }

    @Override
    public V getValue(K key) {
        return CacheUtils.getObject(key);
    }

    @Override
    public List<V> getAll() {
        return CacheUtils.getAll();
    }

    @Override
    public boolean clear() {
        CacheUtils.clear();
        return true;
    }

    @Override
    public void afterPropertiesSet() {
        refresh();
        executorService = new ScheduledThreadPoolExecutor(1, (Runnable r) -> {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                thread.setName("ScheduledCache-" + serialNumber.incrementAndGet());
                return thread;
            });
        executorService.scheduleAtFixedRate(task, delaySeconds, periodSeconds, TimeUnit.SECONDS);
    }

    @Override
    public void destroy() {
        task.cancel();
        executorService.shutdown();
    }

    class Task extends TimerTask {

        @Override
        public void run() {
            if (!refresh()) {
                throw new DranaIllegalStateException("刷新缓存失败", ResultCodeEnum.SERVICE_UNAVAILABLE);
            }
        }
    }
}

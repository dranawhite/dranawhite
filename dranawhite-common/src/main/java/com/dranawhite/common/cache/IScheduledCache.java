package com.dranawhite.common.cache;

/**
 *
 * @author dranawhite
 * @version $Id: IScheduledCache.java, v 0.1 2019-01-12 11:17 dranawhite Exp $$
 */
public interface IScheduledCache<K, V> extends ICache<K, V> {

    /**
     * 刷新缓存
     *
     * @return
     */
    boolean refresh();

}

package com.dranawhite.common.cache.scheduled;

import java.util.List;

/**
 * 缓存接口
 *
 * @author dranawhite
 * @version $Id: ICache.java, v 0.1 2019-01-12 11:18 dranawhite Exp $$
 */
public interface ICache<K, V> {

    /**
     * 缓存对象
     *
     * @param key   KEY
     * @param value VALUE
     */
    void cache(K key, V value);

    /**
     * 查询缓存
     *
     * @param key KEY
     */
    V getValue(K key);

    /**
     * 查询全部数据
     *
     * @return list
     */
    List<V> getAll();

    /**
     * 清空缓存
     *
     * @return true or false
     */
    boolean clear();
}

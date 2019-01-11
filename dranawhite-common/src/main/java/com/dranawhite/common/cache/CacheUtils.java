package com.dranawhite.common.cache;

import com.dranawhite.common.validate.ArgumentValidator;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * 缓存工具类
 * <pre>
 *     内存不足时释放缓存
 * </pre>
 *
 * @author dranawhite
 * @version $Id: CacheUtils.java, v 0.1 2018-09-12 19:53 dranawhite Exp $$
 */
public final class CacheUtils {

    private static WeakHashMap<String, WeakReference> map;

    static {
        map = new WeakHashMap<>(32);
    }

    /**
     * 缓存值
     *
     * @param key 键
     * @param obj 值
     * @param <T> clz
     */
    public static <T> void cacheObject(String key, T obj) {
        ArgumentValidator.checkNotNull(key, obj);
        WeakReference<T> reference = new WeakReference<>(obj);
        map.put(key, reference);
    }

    /**
     * 从缓存中取值
     *
     * @param key 键
     * @param <T> clz
     * @return T
     */
    public static <T> T borrowObject(String key) {
        ArgumentValidator.checkNotNull(key);
        if (!map.containsKey(key)) {
            return null;
        }
        WeakReference<T> reference = map.get(key);
        return reference.get();
    }

}

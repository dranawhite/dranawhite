package com.dranawhite.common.cache;

import com.dranawhite.common.validate.ArgumentValidator;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    private static WeakHashMap<Object, WeakReference> map;

    static {
        map = new WeakHashMap<>(32);
    }

    /**
     * 缓存值
     *
     * @param key   键
     * @param value 值
     * @param <K>   key
     * @param <V>   value
     */
    public static <K, V> void cacheObject(K key, V value) {
        ArgumentValidator.checkNotNull(key, value);
        WeakReference<V> reference = new WeakReference<>(value);
        map.put(key, reference);
    }

    /**
     * 从缓存中取值
     *
     * @param key 键
     * @param <K> clz
     * @return V
     */
    public static <K, V> V getObject(K key) {
        ArgumentValidator.checkNotNull(key);
        if (!map.containsKey(key)) {
            return null;
        }
        WeakReference<V> reference = map.get(key);
        return reference.get();
    }

    /**
     * 从缓存中获取所有值
     *
     * @param <V> value
     * @return list
     */
    public static <V> List<V> getAll() {
        List<V> elementList = new ArrayList<>();
        for (Map.Entry<Object, WeakReference> entry : map.entrySet()) {
            WeakReference reference = entry.getValue();
            V value = (V) reference.get();
            if (value != null) {
                elementList.add(value);
            }
        }
        return elementList;
    }

    /**
     * 清空缓存
     */
    public static void clear() {
        map.clear();
    }
}

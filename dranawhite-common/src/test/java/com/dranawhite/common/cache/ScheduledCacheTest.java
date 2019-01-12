package com.dranawhite.common.cache;

import com.dranawhite.common.cache.scheduled.AbstractScheduledCache;
import com.dranawhite.common.common.ThreadUnit;

/**
 * 缓存Test
 *
 * @author dranawhite
 * @version $Id: ScheduledCacheTest.java, v 0.1 2019-01-12 11:53 dranawhite Exp $$
 */
public class ScheduledCacheTest extends AbstractScheduledCache<String, String> {

    @Override
    public boolean refresh() {
        System.out.println("Clear Cache!");
        if(!clear()) {
            return false;
        }
        System.out.println("Refresh Cache!");
        cache("01", "Test001");
        cache("02", "Test002");
        return true;
    }

    public static void main(String[] args) {
        ScheduledCacheTest cacheTest = new ScheduledCacheTest();
        cacheTest.setDelaySeconds(10);
        cacheTest.afterPropertiesSet();
        System.out.println(cacheTest.getValue("01"));
        cacheTest.cache("01", "Test003");
        System.out.println(cacheTest.getValue("01"));
        ThreadUnit.sleep(15);
        System.out.println(cacheTest.getValue("01"));
        cacheTest.destroy();
    }
}

package com.dranawhite.common.cache;

import com.dranawhite.common.model.Person;
import com.dranawhite.common.util.ThreadUnit;

import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * @author dranawhite
 * @version $Id: CacheUtilTest.java, v 0.1 2019-01-10 20:07 dranawhite Exp $$
 */
public class CacheUtilTest {

    @Test
    public void testCache() {
        {
            Person pn_1 = new Person(1, "tom", 12, null);
            Person pn_2 = new Person(2, "jerry", 15, null);
            CacheUtils.cacheObject("01", pn_1);
            CacheUtils.cacheObject("02", pn_2);
        }

        // 替换局部变量表中的对象，触发回收
        int num_1 = 0;
        int num_2 = 0;

        System.out.println("GC Before: " + CacheUtils.getObject("02"));

        System.gc();
        ThreadUnit.sleep(5);
        System.out.println("GC After: " + CacheUtils.getObject("02"));
        CacheUtils.cacheObject("02", new Person(2, "jerry", 15, null));
        System.out.println("After: " + CacheUtils.getObject("02"));
    }

    @Test
    public void testWeakHashMap() {
        Person pn_1 = new Person(1, "tom", 12, null);
        Person pn_2 = new Person(2, "jerry", 15, null);
        WeakHashMap map = new WeakHashMap();

        // 使用字符串对象，当对象不被引用时，可以回收
        map.put(new String("01"), pn_1);
        map.put(new String("02"), pn_2);

        // 消除对Person对象的引用
        pn_1 = null;
        pn_2 = null;
        System.out.println("GC Before: " + map.get("02"));
        System.gc();
        ThreadUnit.sleep(5);
        System.out.println("GC After: " + map.get("02"));
        System.out.println("GC After: Size = " + map.size());
    }

    @Test
    public void testWeakReference_Object() {
        // 通过new创建字符串是在堆中生成一个对象
        String str = new String("AR47");
        WeakReference<String> reference = new WeakReference<>(str);

        // 消除强引用
        str = null;
        System.gc();
        ThreadUnit.sleep(3);
        System.out.println("Str: " + reference.get());
    }

    @Test
    public void testWeakReference_Primitive() {
        // 直接在字符串池中生成
        String str = "AR 47";
        WeakReference<String> reference = new WeakReference<>(str);

        // 消除强引用
        str = null;
        System.gc();
        ThreadUnit.sleep(3);
        System.out.println("Str: " + reference.get());
        System.out.println(reference.get().intern() == "AR 47");
    }
}

package com.dranawhite.common.resource;

import java.util.Set;

import javax.annotation.Nonnull;

/**
 *
 * @author dranawhite
 * @version : TestAnn.java, v 0.1 2019-08-12 18:29 dranawhite Exp $$
 */
@Nonnull
public class TestAnn {

    public static void main(String[] args) {
        Set<Class<?>> clzSet = ClassScanner.scan("com.dranawhite.common", Nonnull.class);
        clzSet.forEach(clz -> System.out.println(clz.getSimpleName()));
    }
}

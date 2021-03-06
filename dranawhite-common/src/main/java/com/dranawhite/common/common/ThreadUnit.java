package com.dranawhite.common.common;

import com.dranawhite.common.exception.DranaSystemException;
import com.dranawhite.common.exception.GenericResultCode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author dranawhite
 * @version [1.0, 2018/5/16 15:44]
 */
public final class ThreadUnit {

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ex) {
            throw new DranaSystemException("线程中断异常!", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }

    public static void wait(CountDownLatch latch) {
        try {
            latch.await();
        } catch (InterruptedException ex) {
            throw new DranaSystemException("线程中断异常!", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }

    public static void wait(Object obj) {
        try {
            obj.wait();
        } catch (InterruptedException ex) {
            throw new DranaSystemException("线程中断异常!", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }
}

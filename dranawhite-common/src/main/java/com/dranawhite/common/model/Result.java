/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.dranawhite.common.model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author liangyuquan
 * @version : Result.java, v 0.1 2019-11-09 14:37 liangyuquan Exp $$
 */
@Setter
@Getter
public class Result<T> {

    private T data;

    private int code;

    private String desc;
}

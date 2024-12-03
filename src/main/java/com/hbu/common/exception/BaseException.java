package com.hbu.common.exception;

/**
 * @ClassName BaseException
 * @Description TODO
 * @Author awei
 * @Date 2024/11/30 17:14
 */

public class BaseException extends RuntimeException{
    public BaseException() {
    }
    public BaseException(String msg) {
        super(msg);
    }
}

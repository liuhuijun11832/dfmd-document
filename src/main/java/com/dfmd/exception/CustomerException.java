package com.dfmd.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description: 自定义异常
 * @Author: Joy
 * @Date: 2019-07-16 16:05
 */
@Getter
@Setter
public class CustomerException extends RuntimeException {

    private static final long serialVersionUID = 4564124491192825748L;

    private int code;

    public CustomerException(int code) {
        super();
        this.code = code;
    }

    public CustomerException(String message, int code) {
        super(message);
        this.code = code;
    }
}

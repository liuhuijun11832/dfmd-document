package com.dfmd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpStatus;

/**
 * @Description: 错误响应模板
 * @Author: Joy
 * @Date: 2019-07-16 16:10
 */
@Getter
@Setter
public class ResponseEntity<T> {

    private int code;

    private String message;

    private T t;

    public ResponseEntity(int code) {
        this.code = code;
    }

    public ResponseEntity(String message) {
        this.message = message;
    }

    public ResponseEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseEntity success() {
        return new ResponseEntity(HttpStatus.SC_OK, "请求成功");
    }

    public static ResponseEntity fail(int code, String message) {
        return new ResponseEntity(code, message == null || message.length() == 0 ? "服务器错误" : message);
    }
}

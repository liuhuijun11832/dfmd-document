package com.dfmd.controller;

import com.dfmd.entity.ResponseEntity;
import com.dfmd.exception.CustomerException;
import org.apache.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 异常处理类
 * @Author: Joy
 * @Date: 2019-07-16 16:17
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CustomerException.class)
    public ResponseEntity customerExceptionHandler(HttpServletRequest request, Exception e, HttpServletResponse response) {
        response.setStatus(HttpStatus.SC_BAD_REQUEST);
        CustomerException customerException = (CustomerException) e;
        return ResponseEntity.fail(response.getStatus(), customerException.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity runtimeExceptionHandler(HttpServletRequest request, Exception e, HttpServletResponse response) {
        response.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        RuntimeException runtimeException = (RuntimeException) e;
        return ResponseEntity.fail(response.getStatus(), runtimeException.getMessage());
    }

    @Override
    protected org.springframework.http.ResponseEntity handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, org.springframework.http.HttpStatus status, WebRequest request) {
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            return new org.springframework.http.ResponseEntity(new ResponseEntity(status.value(), exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()), status);
        }
        if (ex instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
            return new org.springframework.http.ResponseEntity(new ResponseEntity(status.value(), exception.getLocalizedMessage()), status);
        }
        return new org.springframework.http.ResponseEntity(new ResponseEntity(status.value(), ex.getLocalizedMessage()), status);
    }
}

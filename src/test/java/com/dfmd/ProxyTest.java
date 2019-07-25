package com.dfmd;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: Joy
 * @Date: 2019-07-25 11:32
 */
public class ProxyTest {

    public static void main(String[] args) {
        IStudentDao stuDao = new StudentDao();
        InvocationHandler handler = new MyInvocationHandler(stuDao);
        IStudentDao studentDao = (IStudentDao) Proxy.newProxyInstance(stuDao.getClass().getClassLoader(), stuDao.getClass().getInterfaces(), handler);
        studentDao.save();
    }

}

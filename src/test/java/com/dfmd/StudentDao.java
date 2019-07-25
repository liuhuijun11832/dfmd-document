package com.dfmd;

/**
 * @Description:
 * @Author: Joy
 * @Date: 2019-07-25 13:10
 */
public class StudentDao implements IStudentDao {
    @Override
    public void save() {
        System.out.println("保存了");
    }
}

package com.dfmd.service.impl;

import com.dfmd.entity.User;
import com.dfmd.mapper.LoginMapper;
import com.dfmd.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 登录业务实现类
 * @Author Joy
 * @Date 2019-07-09 23:38
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User test() {
        User user = new User();
        user.setId(1);
        return loginMapper.selectByPrimaryKey(user);
    }
}

package com.dfmd.service.impl;

import com.dfmd.entity.AdminUser;
import com.dfmd.mapper.AdminUserMapper;
import com.dfmd.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Joy
 * @Date: 2019-07-10 15:52
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser test() {
        log.info("进入service");
        AdminUser adminUser = new AdminUser();
        adminUser.setId(1);
        return adminUserMapper.selectByPrimaryKey(adminUser);
    }
}

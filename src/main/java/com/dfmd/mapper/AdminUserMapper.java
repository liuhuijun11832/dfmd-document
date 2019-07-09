package com.dfmd.mapper;

import com.dfmd.entity.AdminUser;

public interface AdminUserMapper {
    int insert(AdminUser record);

    int insertSelective(AdminUser record);
}
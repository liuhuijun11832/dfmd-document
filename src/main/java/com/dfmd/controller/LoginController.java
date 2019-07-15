package com.dfmd.controller;

import com.dfmd.entity.AdminUser;
import com.dfmd.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

/**
 * @Description 登录
 * @Author Joy
 * @Date 2019-07-09 21:08
 */
@Slf4j
@Controller
public class LoginController {


    @Autowired
    LoginService loginService;

    @GetMapping("/index")
    public String test(){
        log.info("进入首页");
        AdminUser adminUser = null;
        try {
            adminUser = loginService.test();
            log.info("获得用户名为:{}", adminUser.getNickName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return "index";
    }

}

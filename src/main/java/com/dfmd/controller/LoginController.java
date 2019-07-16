package com.dfmd.controller;

import com.dfmd.entity.AdminUser;
import com.dfmd.service.LoginService;
import com.dfmd.util.ActivityKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    RuntimeService runtimeService;

    @GetMapping("/index")
    public String test() throws IOException, SolrServerException {
        log.info("进入首页");
        AdminUser adminUser = loginService.test();
        log.info("获得用户名为:{}", adminUser.getNickName());
        return "index";
    }

    @ResponseBody
    @GetMapping("/activiti")
    public void activitiTest() {
        log.info("开始请假测试流程:{}", ActivityKeyEnum.TEST_PROCESS.getKey());
        Map<String, Object> param = new HashMap<>();
        param.put("jobNumber", "A1001");
        param.put("busData", "busData");

        //启动流程
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(ActivityKeyEnum.TEST_PROCESS.getKey(), param);
        log.info("启动流程实例成功:{}", instance);

        //验证是否启启动成功
        ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery();
        List<ProcessInstance> runningList = query.processInstanceId(instance.getProcessInstanceId()).list();
        log.info("根据流程实例id:{}查询到{}条运行中的任务", instance.getProcessInstanceId(), runningList.size());
    }
}

package com.dfmd;

import lombok.extern.slf4j.Slf4j;
import org.activiti.api.task.runtime.events.TaskAssignedEvent;
import org.activiti.api.task.runtime.events.TaskCompletedEvent;
import org.activiti.api.task.runtime.events.listener.TaskRuntimeEventListener;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 测试activiti配置
 * @Author: Joy
 * @Date: 2019-07-15 17:32
 */
@Slf4j
@TestConfiguration
public class DemoActivitiConfig {


    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        String[][] usersGroupsAndRoles = {
                {"salaboy", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam"},
                {"ryandawsonuk", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam"},
                {"erdemedeiros", "password", "ROLE_ACTIVITI_USER", "GROUP_activitiTeam"},
                {"other", "password", "ROLE_ACTIVITI_USER", "GROUP_otherTeam"},
                {"admin", "password", "ROLE_ACTIVITI_ADMIN"},
        };
        for (String[] usersGroupsAndRole : usersGroupsAndRoles) {
            List<String> authoritiesList = Arrays.asList(Arrays.copyOfRange(usersGroupsAndRole, 2, usersGroupsAndRole.length));

            userDetailsManager.createUser(new User(usersGroupsAndRole[0], passwordEncoder().encode(usersGroupsAndRole[1]), authoritiesList.stream().map(s -> new SimpleGrantedAuthority(s)).collect(Collectors.toList())));
        }
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public TaskRuntimeEventListener<TaskAssignedEvent> taskAssigneedEventListener(){
        return t -> log.info("任务分配:{}可以发送通知给任务处理人{}", t.getEntity().getName(), t.getEntity().getAssignee());
    }

    @Bean
    public TaskRuntimeEventListener<TaskCompletedEvent> taskCompletedListener(){
        return t -> log.info("任务完成:{}可以发送通知给任务发起人{}", t.getEntity().getName(), t.getEntity().getOwner());
    }

}

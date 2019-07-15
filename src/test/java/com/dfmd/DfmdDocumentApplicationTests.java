package com.dfmd;

import lombok.extern.slf4j.Slf4j;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DfmdDocumentApplicationTests {

    @Autowired
    private TaskRuntime taskRuntime;

    @Autowired
    private SecurityUtil securityUtil;

    @Test
    public void contextLoads() {
        securityUtil.logInAs("salaboy");

        log.info("为{}创建一个组任务", "activitiTeam");
        taskRuntime.create(TaskPayloadBuilder.create()
                .withName("第一个任务")
                .withDescription("这是一件非常重要的事")
                .withCandidateGroup("activitiTeam")
                .withPriority(10)
                .build());

        securityUtil.logInAs("other");
        log.info("获取所有任务");
        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));
        log.info("其他人无法看到该任务:{}", tasks.getTotalItems());

        securityUtil.logInAs("erdemedeiros");
        log.info("erdemedeiros");
        tasks = taskRuntime.tasks(Pageable.of(0, 10));
        String avaliabledTaskId = tasks.getContent().get(0).getId();

        log.info("处理该任务:{}", avaliabledTaskId);
        taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(avaliabledTaskId).build());

        log.info("该任务完成:{}", avaliabledTaskId);
        taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(avaliabledTaskId).build());
    }

}

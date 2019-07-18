# Spring Boot整合Solr和Activiti的示例项目
## 基础架构
- Spring Boot 2.1.6.RELEASE
- Activiti 7.1.0.M1
- Spring Boot Data Solr

该项目可直接clone到本地，目前配置文件中的Solr的服务器版本为8.1.1，详情可访问:[http://www.guitar-coder.cn:8983/solr/#/](http://www.guitar-coder.cn:8983/solr/#/),
该地址目前可正常访问。
activite模拟了一个请假的流程，具体如图：

![https://github.com/liuhuijun11832/dfmd-document/blob/master/src/main/resources/processes/leave-process.bpmn.png](https://github.com/liuhuijun11832/dfmd-document/blob/master/src/main/resources/processes/leave-process.bpmn.png)
## 测试
本地启动成功以后，可以访问本地[http://localhost:8080/index](http://localhost:8080/index)以及[http://localhost:8080/activiti](http://localhost:8080/activiti)查看控制台输出结果。
solr查询结果和数据库查询结果为：
```
2019-07-16 23:04:29.942  INFO 14760 --- [nio-8080-exec-1] com.dfmd.controller.LoginController      : 进入首页
2019-07-16 23:04:29.943  INFO 14760 --- [nio-8080-exec-1] com.dfmd.service.impl.LoginServiceImpl   : 进入service
2019-07-16 23:04:29.943  INFO 14760 --- [nio-8080-exec-1] com.dfmd.service.impl.LoginServiceImpl   : 创建solr索引:test
2019-07-16 23:04:29.943  INFO 14760 --- [nio-8080-exec-1] com.dfmd.service.impl.LoginServiceImpl   : 开始查询:test
2019-07-16 23:04:29.995  INFO 14760 --- [nio-8080-exec-1] com.dfmd.service.impl.LoginServiceImpl   : 查询结果:{numFound=1,start=0,docs=[SolrDocument{id=1, username=[xiaoming], password=[123], _version_=1639106229691219968}]}
2019-07-16 23:04:30.043  INFO 14760 --- [nio-8080-exec-1] com.dfmd.service.impl.LoginServiceImpl   : 结果:1#[xiaoming]#[123]#null
2019-07-16 23:04:30.068 DEBUG 14760 --- [nio-8080-exec-1] c.dfmd.mapper.AdminUserMapper.selectOne  : ==>  Preparing: SELECT id,username,password,nick_name,head_img,status,create_time,update_time FROM admin_user WHERE id = ? 
2019-07-16 23:04:30.083 DEBUG 14760 --- [nio-8080-exec-1] c.dfmd.mapper.AdminUserMapper.selectOne  : ==> Parameters: 1(Integer)
2019-07-16 23:04:30.102 DEBUG 14760 --- [nio-8080-exec-1] c.dfmd.mapper.AdminUserMapper.selectOne  : <==      Total: 1
2019-07-16 23:04:30.103  INFO 14760 --- [nio-8080-exec-1] com.dfmd.controller.LoginController      : 获得用户名为:xiaoming
2019-07-16 23:04:30.683  WARN 14760 --- [nio-8080-exec-1] o.a.c.util.SessionIdGeneratorBase        : Creation of SecureRandom instance for session ID generation using [SHA1PRNG] took [234] milliseconds.

```
activiti测试结果为：
```
2019-07-16 23:05:42.105  INFO 14760 --- [nio-8080-exec-3] com.dfmd.controller.LoginController      : 开始请假测试流程:myProcess_1
2019-07-16 23:05:42.302  INFO 14760 --- [nio-8080-exec-3] com.dfmd.controller.LoginController      : 启动流程实例成功:ProcessInstance[2de6888b-a7db-11e9-b67e-005056c00001]
2019-07-16 23:05:42.350  INFO 14760 --- [nio-8080-exec-3] com.dfmd.controller.LoginController      : 根据流程实例id:2de6888b-a7db-11e9-b67e-005056c00001查询到1条运行中的任务
```

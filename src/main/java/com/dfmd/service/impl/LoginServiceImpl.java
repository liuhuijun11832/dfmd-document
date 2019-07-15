package com.dfmd.service.impl;

import com.dfmd.entity.AdminUser;
import com.dfmd.mapper.AdminUserMapper;
import com.dfmd.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private SolrClient solrClient;

    @Override
    public AdminUser test() throws IOException, SolrServerException {
        log.info("进入service");
        AdminUser adminUser = new AdminUser();
        adminUser.setId(1);
        AdminUser adminUser1 = new AdminUser();
        adminUser1.setId(2);
        adminUser1.setUsername("xiaohua");

        log.info("创建solr索引:{}", "test");
        //SolrInputDocument solrInputFields = new SolrInputDocument();
        //solrInputFields.addField("id", 1);
        //solrInputFields.addField("username", "xiaoming");
        //solrInputFields.addField("password", "123");
        //solrClient.add(solrInputFields);
        //solrClient.commit();



        //第一种查询方式
        log.info("开始查询:{}", "test");
        ModifiableSolrParams params = new ModifiableSolrParams();
        params.add("q", "username:xiaoming");
        params.add("ws", "json");
        params.add("start", "0");
        params.add("rows", "10");
        QueryResponse queryResponse = solrClient.query(params);
        log.info("查询结果:{}", queryResponse.getResults().toString());

        //第二种查询方式
        int page = 0;
        int rows = 10;
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("username:xiaoming");
        solrQuery.setStart(page);
        solrQuery.setRows(rows);
        QueryResponse queryResponse1 = solrClient.query(solrQuery);
        SolrDocumentList solrDocumentList = queryResponse1.getResults();
        for (int i = 0; i < solrDocumentList.size(); i++) {
            log.info("结果:{}", solrDocumentList.get(i).get("id") + "#" + solrDocumentList.get(i).get("username") + "#" + solrDocumentList.get(i).get("password") + "#" + solrDocumentList.get(i).get("vsername"));
        }
        return adminUserMapper.selectOne(adminUser);
    }
}

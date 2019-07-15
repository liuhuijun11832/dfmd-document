package com.dfmd.service;

import com.dfmd.entity.AdminUser;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * @Description: 登录业务
 * @Author: Joy
 * @Date: 2019-07-10 15:51
 */
public interface LoginService {
    AdminUser test() throws IOException, SolrServerException;
}

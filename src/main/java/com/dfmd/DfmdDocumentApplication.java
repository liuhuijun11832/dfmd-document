package com.dfmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.dfmd.mapper")
@SpringBootApplication
public class DfmdDocumentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DfmdDocumentApplication.class, args);
    }

}

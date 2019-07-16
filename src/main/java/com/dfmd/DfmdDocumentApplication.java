package com.dfmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.dfmd.mapper")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})
public class DfmdDocumentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DfmdDocumentApplication.class, args);
    }

}

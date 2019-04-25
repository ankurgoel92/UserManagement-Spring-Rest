package com.spring.common.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.spring.common.web" })
public class CommonWebConfig {

    public CommonWebConfig() {
        super();
    }

}

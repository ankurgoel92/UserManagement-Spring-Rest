package org.spring.um.spring;

import org.spring.client.spring.CommonClientConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.spring.common.spring.CommonWebConfig;

@Configuration
@ComponentScan({ "org.spring.test.common" })
@Import({ CommonClientConfig.class, CommonWebConfig.class })
public class CommonTestConfig {

    public CommonTestConfig() {
        super();
    }

}

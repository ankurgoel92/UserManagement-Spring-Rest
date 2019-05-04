package org.spring.client.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.spring.common.client", "org.spring.client" })
public class CommonClientConfig {

    public CommonClientConfig() {
        super();
    }

}

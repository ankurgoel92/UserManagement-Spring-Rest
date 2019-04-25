package org.spring.client.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "org.spring.common.client", "org.spring.client" })
public class CommonClientConfig {

    public CommonClientConfig() {
        super();
    }

}

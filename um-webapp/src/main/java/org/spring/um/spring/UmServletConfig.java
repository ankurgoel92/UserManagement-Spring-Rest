package org.spring.um.spring;

import org.spring.um.security.SimpleCorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UmServletConfig {

    public UmServletConfig() {
        super();
    }

    // beans    

    @Bean
    public SimpleCorsFilter simpleCorsFilter() {
        return new SimpleCorsFilter();
    }

}

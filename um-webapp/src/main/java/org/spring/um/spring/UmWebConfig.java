package org.spring.um.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({ "com.spring.common.web", "org.spring.um.web" })
@EnableWebMvc
public class UmWebConfig implements WebMvcConfigurer {

    public UmWebConfig() {
        super();
    }

    // beans

}

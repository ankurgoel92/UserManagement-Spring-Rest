package org.spring.um.run;

import org.spring.um.persistence.setup.MyApplicationContextInitializer;
import org.spring.um.spring.UmContextConfig;
import org.spring.um.spring.UmPersistenceJpaConfig;
import org.spring.um.spring.UmServiceConfig;
import org.spring.um.spring.UmServletConfig;
import org.spring.um.spring.UmWebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = { // @formatter:off
        ErrorMvcAutoConfiguration.class
})// @formatter:on
public class UmApp {

    private final static Class[] CONFIGS = { // @formatter:off
            UmContextConfig.class,
            UmPersistenceJpaConfig.class,
            UmServiceConfig.class,
            UmWebConfig.class,
            UmServletConfig.class,

            UmApp.class
    }; // @formatter:on

    //

    public static void main(final String... args) {
        final SpringApplication springApplication = new SpringApplication(CONFIGS);
        springApplication.addInitializers(new MyApplicationContextInitializer());
        springApplication.run(args);
    }

}

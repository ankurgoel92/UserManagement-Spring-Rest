package org.spring.um.run;

import org.spring.um.persistence.setup.MyApplicationContextInitializer;
import org.spring.um.spring.UmContextConfig;
import org.spring.um.spring.UmJavaSecurityConfig;
import org.spring.um.spring.UmPersistenceJpaConfig;
import org.spring.um.spring.UmServiceConfig;
import org.spring.um.spring.UmServletConfig;
import org.spring.um.spring.UmWebConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = { // @formatter:off
        SecurityAutoConfiguration.class
        , ErrorMvcAutoConfiguration.class
}) // @formatter:on
@Import({ // @formatter:off
    UmContextConfig.class,
    UmPersistenceJpaConfig.class,
    UmServiceConfig.class,
    UmWebConfig.class,
    UmServletConfig.class,
    UmJavaSecurityConfig.class
}) // @formatter:on
public class UmApp {

    public UmApp() {
        super();
    }

    //

    public static void main(final String... args) {
        new SpringApplicationBuilder(UmApp.class).initializers(new MyApplicationContextInitializer()).run(args);
    }

}

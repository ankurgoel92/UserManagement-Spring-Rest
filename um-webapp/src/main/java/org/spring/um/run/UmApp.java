package org.spring.um.run;

import org.spring.um.persistence.setup.MyApplicationContextInitializer;
import org.spring.um.spring.AuthorizationServerConfiguration;
import org.spring.um.spring.ResourceServerConfiguration;
import org.spring.um.spring.UmContextConfig;
import org.spring.um.spring.UmPersistenceJpaConfig;
import org.spring.um.spring.UmServiceConfig;
import org.spring.um.spring.UmWebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = { // @formatter:off
        ErrorMvcAutoConfiguration.class
})// @formatter:on
public class UmApp {

    private final static Class[] CONFIGS = { // @formatter:off
            UmContextConfig.class,
            UmPersistenceJpaConfig.class,
            UmServiceConfig.class,
            UmWebConfig.class,            

            UmApp.class,

            ResourceServerConfiguration.class,
            AuthorizationServerConfiguration.class
    }; // // @formatter:on

    //

    public static void main(final String... args) {
        final SpringApplication springApplication = new SpringApplication(CONFIGS);
        springApplication.addInitializers(new MyApplicationContextInitializer());
        springApplication.run(args);
    }

    @Configuration
    public static class AuthenticationMananagerProvider extends WebSecurityConfigurerAdapter {

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }
}

package org.spring.um;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.um.spring.UmContextConfig;
import org.spring.um.spring.UmJavaSecurityConfig;
import org.spring.um.spring.UmPersistenceJpaConfig;
import org.spring.um.spring.UmServiceConfig;
import org.spring.um.spring.UmWebConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { // @formatter:off
        UmContextConfig.class,

        UmPersistenceJpaConfig.class,

        UmServiceConfig.class,

        UmWebConfig.class,
        
        UmJavaSecurityConfig.class
})// @formatter:on
@WebAppConfiguration
public class WebSpringIntegrationTest {

    @Test
    public final void whenContextIsBootstrapped_thenOk() {
        //
    }

}

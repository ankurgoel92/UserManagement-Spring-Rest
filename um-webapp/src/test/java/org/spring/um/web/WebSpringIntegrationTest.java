package org.spring.um.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.client.spring.CommonClientConfig;
import org.spring.um.spring.UmClientConfig;
import org.spring.um.spring.UmContextConfig;
import org.spring.um.spring.UmPersistenceJpaConfig;
import org.spring.um.spring.UmServiceConfig;
import org.spring.um.spring.UmWebConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CommonClientConfig.class, UmPersistenceJpaConfig.class, UmContextConfig.class, UmServiceConfig.class, UmClientConfig.class, UmWebConfig.class })
@WebAppConfiguration
public class WebSpringIntegrationTest {

    @Test
    public final void whenContextIsBootstrapped_thenOk() {
        //
    }

}

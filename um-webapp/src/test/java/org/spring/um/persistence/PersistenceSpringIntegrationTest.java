package org.spring.um.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.um.spring.UmPersistenceJpaConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UmPersistenceJpaConfig.class }, loader = AnnotationConfigContextLoader.class)
public class PersistenceSpringIntegrationTest {

    @Test
    public final void whenContextIsBootstrapped_thenOk() {
        //
    }

}

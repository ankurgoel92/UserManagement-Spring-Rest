package org.spring.um.service.main;

import org.junit.runner.RunWith;
import org.spring.test.common.service.AbstractServiceIntegrationTest;
import org.spring.um.spring.UmClientConfig;
import org.spring.um.spring.UmContextConfig;
import org.spring.um.spring.UmPersistenceJpaConfig;
import org.spring.um.spring.UmServiceConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.spring.common.persistence.model.INameableEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UmPersistenceJpaConfig.class, UmServiceConfig.class, UmContextConfig.class, UmClientConfig.class }, loader = AnnotationConfigContextLoader.class)
public abstract class SecServiceIntegrationTest<T extends INameableEntity> extends AbstractServiceIntegrationTest<T> {

    //

}

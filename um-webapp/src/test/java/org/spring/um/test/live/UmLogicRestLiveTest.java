package org.spring.um.test.live;

import org.junit.runner.RunWith;
import org.spring.test.common.web.AbstractLogicLiveTest;
import org.spring.um.spring.CommonTestConfig;
import org.spring.um.spring.UmClientConfig;
import org.spring.um.spring.UmLiveTestConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.spring.common.interfaces.INameableDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UmLiveTestConfig.class, UmClientConfig.class, CommonTestConfig.class }, loader = AnnotationConfigContextLoader.class)
public abstract class UmLogicRestLiveTest<T extends INameableDto> extends AbstractLogicLiveTest<T> {

    public UmLogicRestLiveTest(final Class<T> clazzToSet) {
        super(clazzToSet);
    }

}

package org.spring.um.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.spring.um.service.main.PrivilegeServiceIntegrationTest;
import org.spring.um.service.main.RoleServiceIntegrationTest;
import org.spring.um.service.main.UserServiceIntegrationTest;

@RunWith(Suite.class)
@SuiteClasses({ // @formatter:off
    UserServiceIntegrationTest.class,
    PrivilegeServiceIntegrationTest.class,
    RoleServiceIntegrationTest.class
})
// @formatter:on
public final class ServiceSuite {
    //
}

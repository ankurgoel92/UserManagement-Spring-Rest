package org.spring.um.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.spring.um.security.AuthenticationRestLiveTest;
import org.spring.um.web.privilege.PrivilegeLogicRestLiveTest;
import org.spring.um.web.privilege.PrivilegeReadOnlyLogicRestLiveTest;
import org.spring.um.web.role.RoleLogicRestLiveTest;
import org.spring.um.web.role.RoleReadOnlyLogicRestLiveTest;
import org.spring.um.web.user.UserLogicRestLiveTest;
import org.spring.um.web.user.UserReadOnlyLogicRestLiveTest;

@RunWith(Suite.class)
@SuiteClasses({ // @formatter:off
    UserLogicRestLiveTest.class,
    UserReadOnlyLogicRestLiveTest.class,

    RoleLogicRestLiveTest.class,
    RoleReadOnlyLogicRestLiveTest.class,

    PrivilegeReadOnlyLogicRestLiveTest.class,
    PrivilegeLogicRestLiveTest.class,

    AuthenticationRestLiveTest.class
})
// @formatter:off
public final class LiveLogicSuite {
    //
}

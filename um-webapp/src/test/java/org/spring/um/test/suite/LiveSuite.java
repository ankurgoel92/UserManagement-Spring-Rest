package org.spring.um.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.spring.um.security.SecurityRestLiveTest;
import org.spring.um.web.role.RoleSimpleLiveTest;

@RunWith(Suite.class)
@SuiteClasses({ // @formatter:off
    LiveLogicSuite.class,
    SecurityRestLiveTest.class,
    RoleSimpleLiveTest.class
})
// @formatter:on
public final class LiveSuite {
    //
}

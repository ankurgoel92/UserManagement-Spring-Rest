package org.spring.um.web.privilege;

import org.spring.um.client.template.PrivilegeTestRestTemplate;
import org.spring.um.persistence.model.Privilege;
import org.spring.um.test.live.UmReadOnlyLogicRestLiveTest;
import org.springframework.beans.factory.annotation.Autowired;

public class PrivilegeReadOnlyLogicRestLiveTest extends UmReadOnlyLogicRestLiveTest<Privilege> {

    @Autowired
    private PrivilegeTestRestTemplate api;

    public PrivilegeReadOnlyLogicRestLiveTest() {
        super(Privilege.class);
    }

    // tests

    // template

    @Override
    protected final PrivilegeTestRestTemplate getApi() {
        return api;
    }

}

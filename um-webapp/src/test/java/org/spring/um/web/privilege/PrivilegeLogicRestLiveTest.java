package org.spring.um.web.privilege;

import org.spring.client.IDtoOperations;
import org.spring.um.client.template.PrivilegeTestRestTemplate;
import org.spring.um.model.PrivilegeDtoOpsImpl;
import org.spring.um.persistence.model.Privilege;
import org.spring.um.test.live.UmLogicRestLiveTest;
import org.springframework.beans.factory.annotation.Autowired;

public class PrivilegeLogicRestLiveTest extends UmLogicRestLiveTest<Privilege> {

    @Autowired
    private PrivilegeTestRestTemplate api;
    @Autowired
    private PrivilegeDtoOpsImpl entityOps;

    public PrivilegeLogicRestLiveTest() {
        super(Privilege.class);
    }

    // tests

    // template

    @Override
    protected final PrivilegeTestRestTemplate getApi() {
        return api;
    }

    @Override
    protected final IDtoOperations<Privilege> getEntityOps() {
        return entityOps;
    }

}

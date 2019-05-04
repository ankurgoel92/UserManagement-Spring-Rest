package org.spring.um.web.role;

import org.spring.um.client.template.PrivilegeTestRestTemplate;
import org.spring.um.client.template.RoleTestRestTemplate;
import org.spring.um.persistence.model.Role;
import org.spring.um.test.live.UmReadOnlyLogicRestLiveTest;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleReadOnlyLogicRestLiveTest extends UmReadOnlyLogicRestLiveTest<Role> {

    @Autowired
    private RoleTestRestTemplate api;
    @Autowired
    private PrivilegeTestRestTemplate associationApi;

    public RoleReadOnlyLogicRestLiveTest() {
        super(Role.class);
    }

    // tests

    // template

    @Override
    protected final RoleTestRestTemplate getApi() {
        return api;
    }

    // util

    final PrivilegeTestRestTemplate getAssociationAPI() {
        return associationApi;
    }

}

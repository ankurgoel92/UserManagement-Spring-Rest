package org.spring.um.web.user;

import org.spring.um.client.template.UserTestRestTemplate;
import org.spring.um.persistence.model.User;
import org.spring.um.test.live.UmReadOnlyLogicRestLiveTest;
import org.springframework.beans.factory.annotation.Autowired;

public class UserReadOnlyLogicRestLiveTest extends UmReadOnlyLogicRestLiveTest<User> {

    @Autowired
    private UserTestRestTemplate api;

    public UserReadOnlyLogicRestLiveTest() {
        super(User.class);
    }

    // tests

    // template method

    @Override
    protected final UserTestRestTemplate getApi() {
        return api;
    }

}

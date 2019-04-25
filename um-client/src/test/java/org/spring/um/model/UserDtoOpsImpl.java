package org.spring.um.model;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import org.spring.client.IDtoOperations;
import org.spring.um.client.FixtureResourceFactory;
import org.spring.um.persistence.model.User;
import org.springframework.stereotype.Component;

@Component
public final class UserDtoOpsImpl implements IDtoOperations<User> {

    public UserDtoOpsImpl() {
        super();
    }

    // API

    // template method

    @Override
    public final User createNewResource() {
        return FixtureResourceFactory.createNewUser();
    }

    @Override
    public final void invalidate(final User entity) {
        entity.setName(null);
    }

    @Override
    public final void change(final User resource) {
        resource.setName(randomAlphabetic(8));
    }

}

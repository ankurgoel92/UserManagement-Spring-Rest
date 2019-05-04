package org.spring.um.client.template;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.spring.test.common.client.template.AbstractRestClient;
import org.spring.um.client.UmPaths;
import org.spring.um.persistence.model.User;
import org.spring.um.util.Um;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("client")
public final class UserTestRestTemplate extends AbstractRestClient<User> {

    @Autowired
    protected UmPaths paths;

    public UserTestRestTemplate() {
        super(User.class);
    }

    // API

    // template method

    @Override
    public final String getUri() {
        return paths.getUserUri();
    }

    @Override
    public final Pair<String, String> getDefaultCredentials() {
        return new ImmutablePair<>(Um.ADMIN_EMAIL, Um.ADMIN_PASS);
    }

}

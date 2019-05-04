package com.spring.common.security;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

public class Base64UnitTest {

    private static final String BASIC_AUTHORIZATION = "Basic YW5rdXJnb2VsLmp1aXRAZ21haWwuY29tOmFua3VyZ29lbDky";

    // tests

    @Test
    public final void whenAuthorizationHeaderIsDecoded_thenNoExceptions() {
        SpringSecurityUtil.decodeAuthorizationKey(BASIC_AUTHORIZATION);
    }

    @Test
    public final void whenAuthorizationHeaderIsDecoded_thenResponseNotNull() {
        final Pair<String, String> authorizationKey = SpringSecurityUtil.decodeAuthorizationKey(BASIC_AUTHORIZATION);

        assertNotNull(authorizationKey);
        assertNotNull(authorizationKey.getLeft());
        assertNotNull(authorizationKey.getRight());
    }

    @Test
    public final void whenAuthorizationHeaderIsDecoded_thenResponseIsCorrect() {
        final Pair<String, String> authorizationKey = SpringSecurityUtil.decodeAuthorizationKey(BASIC_AUTHORIZATION);

        assertThat(authorizationKey.getLeft(), equalTo("ankurgoel.juit@gmail.com"));
        assertThat(authorizationKey.getRight(), equalTo("ankurgoel92"));
    }

}

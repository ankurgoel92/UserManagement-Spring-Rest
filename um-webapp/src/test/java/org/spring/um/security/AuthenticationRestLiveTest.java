package org.spring.um.security;

import static com.spring.common.spring.util.Profiles.CLIENT;
import static com.spring.common.spring.util.Profiles.TEST;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.test.common.client.security.ITestAuthenticator;
import org.spring.um.client.UmPaths;
import org.spring.um.persistence.model.User;
import org.spring.um.spring.CommonTestConfig;
import org.spring.um.spring.UmClientConfig;
import org.spring.um.spring.UmLiveTestConfig;
import org.spring.um.util.Um;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UmLiveTestConfig.class, UmClientConfig.class, CommonTestConfig.class }, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ CLIENT, TEST })
public class AuthenticationRestLiveTest {

    @Autowired
    private UmPaths paths;

    @Autowired
    private ITestAuthenticator auth;

    // tests

    @Test
    public final void whenAuthenticationIsPerformed_then200IsReceived() {
        // When
        final Response response = givenAuthenticated().contentType(APPLICATION_JSON.toString()).get(paths.getAuthenticationUri());

        // Then
        assertThat(response.getStatusCode(), is(200));
    }

    @Test
    public final void whenAuthenticationIsPerformed_thenResponseHasContent() {
        // When
        final Response response = givenAuthenticated().contentType(APPLICATION_JSON.toString()).post(paths.getAuthenticationUri());

        // Then
        assertThat(response.asString(), is(notNullValue()));
    }

    @Test
    public final void whenAuthenticationIsPerformed_thenResponseIsUser() {
        // When
        final Response response = givenAuthenticated().contentType(APPLICATION_JSON.toString()).get(paths.getAuthenticationUri());

        // Then
        response.as(User.class);
    }

    @Test
    public final void whenAuthenticationIsPerformed_thenUserResponseIsCorrect() {
        // When
        final Response response = givenAuthenticated().contentType(APPLICATION_JSON.toString()).get(paths.getAuthenticationUri());

        // Then
        final User actual = response.as(User.class);
        assertEquals(Um.EMAIL, actual.getEmail());
    }

    // util

    protected RequestSpecification givenAuthenticated() {
        return auth.givenAuthenticated(Um.ADMIN_EMAIL, Um.ADMIN_PASS);
    }

}

package org.spring.um.web.role;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.spring.client.IDtoOperations;
import org.spring.test.common.test.contract.IResourceWithAssociationsIntegrationTest;
import org.spring.um.client.template.PrivilegeTestRestTemplate;
import org.spring.um.client.template.RoleTestRestTemplate;
import org.spring.um.model.PrivilegeDtoOpsImpl;
import org.spring.um.model.RoleDtoOpsImpl;
import org.spring.um.persistence.model.Privilege;
import org.spring.um.persistence.model.Role;
import org.spring.um.test.live.UmLogicRestLiveTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Sets;

import io.restassured.response.Response;

public class RoleLogicRestLiveTest extends UmLogicRestLiveTest<Role> implements IResourceWithAssociationsIntegrationTest {

    @Autowired
    private RoleTestRestTemplate api;
    @Autowired
    private PrivilegeTestRestTemplate associationApi;

    @Autowired
    private RoleDtoOpsImpl entityOps;
    @Autowired
    private PrivilegeDtoOpsImpl associationEntityOps;

    public RoleLogicRestLiveTest() {
        super(Role.class);
    }

    // tests

    @Override
    @Test
    public final void givenResourceHasAssociations_whenResourceIsRetrieved_thenAssociationsAreAlsoRetrieved() {
        // Given
        final Privilege existingAssociation = getAssociationAPI().create(getAssociationEntityOps().createNewResource());
        final Role newResource = getEntityOps().createNewResource();
        newResource.getPrivileges().add(existingAssociation);

        // When
        final Role existingResource = getApi().create(newResource);

        // Then
        assertThat(existingResource.getPrivileges(), notNullValue());
        assertThat(existingResource.getPrivileges(), not(Matchers.<Privilege> empty()));
    }

    // create

    @Test
    public final void givenResourceHasNameWithSpace_whenResourceIsCreated_then201IsReceived() {
        final Role newResource = getEntityOps().createNewResource();
        newResource.setName(randomAlphabetic(4) + " " + randomAlphabetic(4));

        // When
        final Response createAsResponse = getApi().createAsResponse(newResource);

        // Then
        assertThat(createAsResponse.getStatusCode(), is(201));
    }

    @Test
    public final void whenCreatingNewResourceWithExistingAssociations_thenNewResourceIsCorrectlyCreated() {
        final Privilege existingAssociation = getAssociationAPI().create(getAssociationEntityOps().createNewResource());
        final Role newResource = getEntityOps().createNewResource();
        newResource.getPrivileges().add(existingAssociation);
        getApi().create(newResource);

        final Role newResource2 = getEntityOps().createNewResource();
        newResource2.getPrivileges().add(existingAssociation);
        getApi().create(newResource2);
    }

    /**
     * - note: this test ensures that a new User cannot automatically create new Privileges <br>
     * - note: the standard way to do this is: first create the Privilege resource(s), then associate them with the new User resource and then create the User resource
     */
    @Test
    public final void whenResourceIsCreatedWithNewAssociation_then409IsReceived() {
        final Role newResource = getEntityOps().createNewResource();
        newResource.getPrivileges().add(getAssociationEntityOps().createNewResource());

        // When
        final Response response = getApi().createAsResponse(newResource);

        // Then
        assertThat(response.getStatusCode(), is(409));
    }

    @Test
    public final void whenResourceIsCreatedWithInvalidAssociation_then409IsReceived() {
        final Privilege invalidAssociation = getAssociationEntityOps().createNewResource();
        getAssociationEntityOps().invalidate(invalidAssociation);
        final Role newResource = getEntityOps().createNewResource();
        newResource.getPrivileges().add(invalidAssociation);

        // When
        final Response response = getApi().createAsResponse(newResource);

        // Then
        assertThat(response.getStatusCode(), is(409));
    }

    @Test
    public final void whenResourceIsCreatedWithExistingAssociation_then201IsReceived() {
        final Privilege existingAssociation = getAssociationAPI().create(getAssociationEntityOps().createNewResource());
        final Role newResource = getEntityOps().createNewResource();
        newResource.getPrivileges().add(existingAssociation);

        // When
        final Response response = getApi().createAsResponse(newResource);

        // Then
        assertThat(response.getStatusCode(), is(201));
    }

    @Test
    public final void whenResourceIsCreatedWithExistingAssociation_thenAssociationIsLinkedToTheResource() {
        final Privilege existingAssociation = getAssociationAPI().create(getAssociationEntityOps().createNewResource());
        final Role resourceToCreate = getEntityOps().createNewResource();

        // When
        resourceToCreate.getPrivileges().add(existingAssociation);
        final Role existingResource = getApi().create(resourceToCreate);

        // Then
        assertThat(existingResource.getPrivileges(), hasItem(existingAssociation));
    }

    // update

    @Test
    public final void givenResourceExists_whenResourceIsUpdatedWithExistingAssociation_thenAssociationIsCorrectlyUpdated() {
        // Given
        final Role existingResource = getApi().create(getEntityOps().createNewResource());
        final Privilege existingAssociation = getAssociationAPI().create(getAssociationEntityOps().createNewResource());
        existingResource.setPrivileges(Sets.newHashSet(existingAssociation));

        // When
        getApi().update(existingResource);

        // Given
        final Role updatedResource = getApi().findOne(existingResource.getId());
        assertThat(updatedResource.getPrivileges(), hasItem(existingAssociation));
    }

    @Test
    public final void givenExistingResourceAndExistingAssociation_whenUpdatingResourceWithTheAssociation_thanAssociationCorrectlyDone() {
        final Role existingResource = getApi().create(getEntityOps().createNewResource());
        final Privilege existingAssociation = getAssociationAPI().create(getAssociationEntityOps().createNewResource());
        existingResource.setPrivileges(Sets.newHashSet(existingAssociation));

        getApi().update(existingResource);
        final Role updatedResource = getApi().findOne(existingResource.getId());
        assertThat(updatedResource.getPrivileges(), hasItem(existingAssociation));
    }

    // complex scenarios

    @Test
    public final void whenScenarioOfWorkingWithAssociations_thenTheChangesAreCorrectlyPersisted() {
        final Privilege existingAssociation = getAssociationAPI().create(getAssociationEntityOps().createNewResource());
        final Role resource1 = new Role(randomAlphabetic(6), Sets.newHashSet(existingAssociation));

        final Role resource1ViewOfServerBefore = getApi().create(resource1);
        assertThat(resource1ViewOfServerBefore.getPrivileges(), hasItem(existingAssociation));

        final Role resource2 = new Role(randomAlphabetic(6), Sets.newHashSet(existingAssociation));
        getApi().create(resource2);

        final Role resource1ViewOfServerAfter = getApi().findOne(resource1ViewOfServerBefore.getId());
        assertThat(resource1ViewOfServerAfter.getPrivileges(), hasItem(existingAssociation));
    }

    // template

    @Override
    protected final RoleTestRestTemplate getApi() {
        return api;
    }

    @Override
    protected final IDtoOperations<Role> getEntityOps() {
        return entityOps;
    }

    // util

    final PrivilegeTestRestTemplate getAssociationAPI() {
        return associationApi;
    }

    final IDtoOperations<Privilege> getAssociationEntityOps() {
        return associationEntityOps;
    }

}

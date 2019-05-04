package org.spring.test.common.client.template;

import org.spring.client.marshall.IMarshaller;
import org.spring.client.template.IRestClientWithUri;

import com.spring.common.interfaces.IDto;
import com.spring.common.interfaces.IOperations;

import io.restassured.specification.RequestSpecification;

public interface IRestClient<T extends IDto> extends IOperations<T>, IRestClientAsResponse<T>, IRestClientWithUri<T> {

    // template

    RequestSpecification givenReadAuthenticated();

    RequestSpecification givenDeleteAuthenticated();

    IMarshaller getMarshaller();

    String getUri();

}

package org.spring.client.template;

import com.spring.common.interfaces.IDto;

public interface IRestClientWithUri<T extends IDto> extends IReadOnlyTemplateWithUri<T> {

    // create

    String createAsUri(final T resource);

}

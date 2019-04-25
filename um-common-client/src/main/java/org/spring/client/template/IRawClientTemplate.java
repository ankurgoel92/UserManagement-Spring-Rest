package org.spring.client.template;

import org.apache.commons.lang3.tuple.Pair;

import com.spring.common.interfaces.IDto;
import com.spring.common.interfaces.IOperations;

public interface IRawClientTemplate<T extends IDto> extends IOperations<T>, ITemplateWithUri<T> {

    //

    String getUri();

    // create

    T create(final T resource, final Pair<String, String> credentials);

    T findOne(final long id, final Pair<String, String> credentials);

}

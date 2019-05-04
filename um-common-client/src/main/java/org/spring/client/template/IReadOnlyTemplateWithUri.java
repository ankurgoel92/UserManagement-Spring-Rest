package org.spring.client.template;

import java.util.List;

import com.spring.common.interfaces.IDto;

public interface IReadOnlyTemplateWithUri<T extends IDto> {

    // find - one

    T findOneByUri(final String uri);

    // find - all

    List<T> findAllByUri(final String uri);

}

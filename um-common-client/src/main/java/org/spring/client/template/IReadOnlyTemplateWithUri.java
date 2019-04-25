package org.spring.client.template;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import com.spring.common.interfaces.IDto;

public interface IReadOnlyTemplateWithUri<T extends IDto> {

    // find - one

    T findOneByUri(final String uri, final Pair<String, String> credentials);

    // find - all

    List<T> findAllByUri(final String uri, final Pair<String, String> credentials);

}

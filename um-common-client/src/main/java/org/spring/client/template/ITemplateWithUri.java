package org.spring.client.template;

import org.apache.commons.lang3.tuple.Pair;
import com.spring.common.interfaces.IDto;

public interface ITemplateWithUri<T extends IDto> extends IReadOnlyTemplateWithUri<T> {

    // create

    String createAsUri(final T resource, final Pair<String, String> credentials);

    String createAsUri(final T resource);

}

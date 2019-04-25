package org.spring.client;

import com.spring.common.interfaces.IDto;

public interface IDtoOperations<T extends IDto> {

    T createNewResource();

    void invalidate(final T entity);

    void change(final T resource);

}

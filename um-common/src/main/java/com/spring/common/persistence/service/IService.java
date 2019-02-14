package com.spring.common.persistence.service;

import com.spring.common.interfaces.IByNameApi;
import com.spring.common.interfaces.IWithName;

public interface IService<T extends IWithName> extends IRawService<T>, IByNameApi<T> {

    //

}

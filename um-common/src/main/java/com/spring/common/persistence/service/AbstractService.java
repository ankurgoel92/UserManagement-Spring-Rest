package com.spring.common.persistence.service;

import com.spring.common.persistence.model.INameableEntity;

public abstract class AbstractService<T extends INameableEntity> extends AbstractRawService<T> implements IService<T> {

    public AbstractService() {
        super();
    }

    // API

}

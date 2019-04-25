package com.spring.common.persistence.service;

import org.springframework.data.domain.Page;

import com.spring.common.interfaces.IOperations;
import com.spring.common.interfaces.IWithName;

public interface IRawService<T extends IWithName> extends IOperations<T> {

    Page<T> findAllPaginatedAndSortedRaw(final int page, final int size, final String sortBy, final String sortOrder);
    Page<T> findAllPaginatedRaw(final int page, final int size);

}

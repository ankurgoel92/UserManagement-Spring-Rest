package com.spring.common.util.order;

import com.google.common.collect.Ordering;
import com.spring.common.interfaces.IWithId;

public final class OrderById<T extends IWithId> extends Ordering<T> {

    public OrderById() {
        super();
    }

    // API

    @Override
    public final int compare(final T left, final T right) {
        return left.getId().compareTo(right.getId());
    }

}

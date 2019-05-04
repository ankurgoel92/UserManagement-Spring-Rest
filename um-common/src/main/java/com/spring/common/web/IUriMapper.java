package com.spring.common.web;

import com.spring.common.interfaces.IDto;

public interface IUriMapper {

    <T extends IDto> String getUriBase(final Class<T> clazz);

}

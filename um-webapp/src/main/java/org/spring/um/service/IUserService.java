package org.spring.um.service;

import org.spring.um.web.dto.UserDto;

import com.spring.common.persistence.service.IService;

public interface IUserService extends IService<UserDto> {

    UserDto getCurrentUser();

}

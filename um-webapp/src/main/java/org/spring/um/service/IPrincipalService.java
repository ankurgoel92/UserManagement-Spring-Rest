package org.spring.um.service;

import org.spring.um.persistence.model.Principal;

import com.spring.common.persistence.service.IService;

public interface IPrincipalService extends IService<Principal> {

    Principal getCurrentPrincipal();

}

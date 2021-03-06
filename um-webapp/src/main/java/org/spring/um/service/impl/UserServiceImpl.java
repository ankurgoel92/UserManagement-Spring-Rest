package org.spring.um.service.impl;

import org.spring.um.persistence.dao.IUserJpaDao;
import org.spring.um.persistence.model.User;
import org.spring.um.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.common.persistence.service.AbstractService;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements IUserService {

    @Autowired
    IUserJpaDao dao;

    public UserServiceImpl() {
        super();
    }

    // API

    // find

    @Override
    @Transactional(readOnly = true)
    public User findByName(final String name) {
        return dao.findByName(name);
    }

    // Spring

    @Override
    protected final IUserJpaDao getDao() {
        return dao;
    }

    @Override
    protected JpaSpecificationExecutor<User> getSpecificationExecutor() {
        return dao;
    }

}

package org.spring.um.service.impl;

import org.spring.um.persistence.dao.IPrincipalJpaDao;
import org.spring.um.persistence.model.Principal;
import org.spring.um.service.IPrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.common.persistence.service.AbstractService;
import com.spring.common.security.SpringSecurityUtil;

@Service
@Transactional
public class PrincipalServiceImpl extends AbstractService<Principal> implements IPrincipalService {

    @Autowired
    private IPrincipalJpaDao dao;

    public PrincipalServiceImpl() {
        super();
    }

    // API

    // find

    @Override
    @Transactional(readOnly = true)
    public Principal findByName(final String name) {
        return dao.findByName(name);
    }

    // other

    @Override
    @Transactional(readOnly = true)
    public Principal getCurrentPrincipal() {
        final String principalName = SpringSecurityUtil.getNameOfCurrentPrincipal();
        return getDao().findByName(principalName);
    }

    // Spring

    @Override
    protected final IPrincipalJpaDao getDao() {
        return dao;
    }

    @Override
    protected JpaSpecificationExecutor<Principal> getSpecificationExecutor() {
        return dao;
    }

}

package cz.cvut.junit.service;

import cz.cvut.junit.dao.HibernateBoxDao;
import cz.cvut.junit.dao.HibernateConfigDao;
import cz.cvut.junit.entity.Box;
import cz.cvut.junit.entity.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.04.16
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    protected HibernateConfigDao hibernateConfigDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Config getConfig() {
        return hibernateConfigDao.getConfig();
    }

    @Override
    @Transactional
    public void persist(Config config) {
        hibernateConfigDao.persist(config);
    }

    @Override
    @Transactional
    public void merge(Config config) {
        hibernateConfigDao.merge(config);

    }
}

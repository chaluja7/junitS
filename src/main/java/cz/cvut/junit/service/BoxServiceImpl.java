package cz.cvut.junit.service;

import cz.cvut.junit.dao.HibernateBoxDao;
import cz.cvut.junit.entity.Box;
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
public class BoxServiceImpl implements BoxService {

    @Autowired
    protected HibernateBoxDao hibernateBoxDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Box find(long id) {
        return hibernateBoxDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Box findByNumber(long number) {
        return hibernateBoxDao.findByNumber(number);
    }

    @Override
    @Transactional
    public void persist(Box box) {
        hibernateBoxDao.persist(box);
    }

    @Override
    @Transactional
    public void merge(Box box) {
        hibernateBoxDao.merge(box);
    }

    @Override
    @Transactional
    public void delete(long id) {
        hibernateBoxDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Box> findAll() {
        return hibernateBoxDao.findAll();
    }
}

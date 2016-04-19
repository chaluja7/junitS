package cz.cvut.junit.service;

import cz.cvut.junit.dao.HibernateItemShelfConnectionDao;
import cz.cvut.junit.entity.ItemShelfConnection;
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
public class ItemShelfConnectionServiceImpl implements ItemShelfConnectionService {

    @Autowired
    protected HibernateItemShelfConnectionDao hibernateItemShelfConnectionDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public ItemShelfConnection find(long id) {
        return hibernateItemShelfConnectionDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ItemShelfConnection> findByShelfNumber(String shelfNumber) {
        return hibernateItemShelfConnectionDao.findByShelfNumber(shelfNumber);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ItemShelfConnection> findByItemType(String type) {
        return hibernateItemShelfConnectionDao.findByItemType(type);
    }

    @Override
    @Transactional
    public void persist(ItemShelfConnection itemShelfConnection) {
        hibernateItemShelfConnectionDao.persist(itemShelfConnection);
    }

    @Override
    @Transactional
    public void merge(ItemShelfConnection itemShelfConnection) {
        hibernateItemShelfConnectionDao.merge(itemShelfConnection);
    }

    @Override
    @Transactional
    public void delete(long id) {
        hibernateItemShelfConnectionDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ItemShelfConnection> findAll() {
        return hibernateItemShelfConnectionDao.findAll();
    }
}

package cz.cvut.junit.service;

import cz.cvut.junit.dao.HibernateItemDao;
import cz.cvut.junit.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.04.16
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    protected HibernateItemDao hibernateItemDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Item find(long id) {
        return hibernateItemDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Item> findByType(String type) {
        if(type == null) return  new ArrayList<>();
        return hibernateItemDao.findByType(type);
    }

    @Override
    @Transactional
    public void persist(Item item) {
        hibernateItemDao.persist(item);
    }

    @Override
    @Transactional
    public void merge(Item item) {
        hibernateItemDao.merge(item);
    }

    @Override
    @Transactional
    public void delete(long id) {
        hibernateItemDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Item> findAll() {
        return hibernateItemDao.findAll();
    }
}

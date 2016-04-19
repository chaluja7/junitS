package cz.cvut.junit.service;

import cz.cvut.junit.dao.HibernateShelfDao;
import cz.cvut.junit.entity.Shelf;
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
public class ShelfServiceImpl implements ShelfService {

    @Autowired
    protected HibernateShelfDao hibernateShelfDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Shelf find(long id) {
        return hibernateShelfDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Shelf findByShelfNumberAndBoxNumber(String shelfNumber, Long boxNumber) {
        return hibernateShelfDao.findByShelfNumberAndBoxNumber(shelfNumber, boxNumber);
    }

    @Override
    @Transactional
    public void persist(Shelf shelf) {
        hibernateShelfDao.persist(shelf);
    }

    @Override
    @Transactional
    public void merge(Shelf shelf) {
        hibernateShelfDao.merge(shelf);
    }

    @Override
    @Transactional
    public void delete(long id) {
        hibernateShelfDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Shelf> findAll() {
        return hibernateShelfDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Shelf> findEmptyShelfs(int minimumCapacity) {

        Shelf shelfForGivenCapacity = hibernateShelfDao.findShelfForGivenCapacity(minimumCapacity);


        return null;
    }
}

package cz.cvut.junit.service;

import cz.cvut.junit.dao.HibernateShelfDao;
import cz.cvut.junit.entity.CoolingType;
import cz.cvut.junit.entity.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    public List<Shelf> findEmptyShelfs(int minimumCapacity, CoolingType coolingType) {
        List<Shelf> allShelfs = hibernateShelfDao.findAllShelfsWithShelfItemConnection(coolingType);

        Map<Integer, List<Shelf>> capacityMap = new TreeMap<>();
        for(Shelf shelf : allShelfs) {
            int freeCapacity = shelf.getFreeCapacity();
            if(capacityMap.containsKey(freeCapacity)) {
                capacityMap.get(freeCapacity).add(shelf);
            } else {
                List<Shelf> list = new ArrayList<>();
                list.add(shelf);
                capacityMap.put(freeCapacity, list);
            }
        }

        for(Map.Entry<Integer, List<Shelf>> entry : capacityMap.entrySet()) {
            if(entry.getKey() >= minimumCapacity) {
                return Collections.singletonList(entry.getValue().get(0));
            }
        }

        //nemam volnou kapacitu - pujde to do vic polic
        List<Shelf> shelfs = new ArrayList<>();
        int alreadyCapacity = 0;
        for(Map.Entry<Integer, List<Shelf>> entry : capacityMap.entrySet()) {
            for(Shelf shelf : entry.getValue()) {
                shelfs.add(shelf);
                alreadyCapacity += entry.getKey();
                if(alreadyCapacity >= minimumCapacity) {
                    return shelfs;
                }
            }
        }

        return null;
    }
}

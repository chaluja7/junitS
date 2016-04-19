package cz.cvut.junit.service;

import cz.cvut.junit.dao.HibernateItemDao;
import cz.cvut.junit.entity.Item;
import cz.cvut.junit.web.wrapper.output.ItemPlaceWithExpiration;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.04.16
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    protected HibernateItemDao hibernateItemDao;

    @Autowired
    protected ConfigService configService;

    @Autowired
    protected ExpirationService expirationService;

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
    public List<Item> findExpiredItems() {
        return hibernateItemDao.findExpiredItems(configService.getConfig().getDate());
    }

    @Override
    @Transactional
    public void deleteItems(List<Item> itemsToDelete) {
        for (Item i : itemsToDelete) {
            delete(i.getId());
        }
    }

    @Override
    @Transactional
    public List getItemsPlaces(List<Item> items){
        return hibernateItemDao.getItemsPlaces(items);

    }

    @Override
    @Transactional
    public List<ItemPlaceWithExpiration> getItemsByType(String meatType, String coolingType) {
        return hibernateItemDao.getItemsByTypes(meatType, coolingType);

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
    public Item createItemObject(String type, boolean isFrozen, Date killDate) {
        Item item = new Item();
        item.setType(type);
        item.setFrozen(isFrozen);
        item.setKillDate(killDate);
        int expirationDays = expirationService.findAll().get(type);
        DateTime expirationDateTime = new DateTime(killDate).plusDays(expirationDays);
        item.setExpirationDate(expirationDateTime.toDate());
        return item;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Item> findAll() {
        return hibernateItemDao.findAll();
    }
}

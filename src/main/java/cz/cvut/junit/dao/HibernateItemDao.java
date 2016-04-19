package cz.cvut.junit.dao;

import cz.cvut.junit.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.junit.entity.Item;
import cz.cvut.junit.web.wrapper.output.ItemPlace;
import cz.cvut.junit.web.wrapper.output.ItemPlaceWithExpiration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
@SuppressWarnings("JpaQueryApiInspection")
public class HibernateItemDao extends AbstractGenericHibernateDao<Item> {

    public HibernateItemDao() {
        super(Item.class);
    }

    public List<Item> findByType(String type) {
        return sessionFactory.getCurrentSession().getNamedQuery("Item.findByType").setParameter("type", type).list();
    }

    public  List<Item> findExpiredItems(Date expireDate) {
        return sessionFactory.getCurrentSession().getNamedQuery("Item.findExpiredItems").setParameter("date",expireDate).list();
    }

    public List getItemsPlaces(List<Item> items) {
        List<Long> itemIds = new ArrayList<>();
        for(Item i:items){
            itemIds.add(i.getId());
        }
        String sql = "SELECT itemshelfs.count, shelfs.shelfnumber,boxes.boxnumber FROM itemshelfs " +
                "JOIN itemshelfs.shelfid = shelfs.id ON shelfs " +
                "JOIN shelfs.boxid = boxes.id ON boxes " +
                "WHERE itemshelfs.itemid IN (:ids)";
        return sessionFactory.getCurrentSession().createSQLQuery(sql).setParameterList("ids", itemIds).list();
    }

    public List<ItemPlaceWithExpiration> getItemsByTypes(String meatType, String coolingType) {
        String sql = "SELECT itemshelfs.count, shelfs.shelfnumber,boxes.boxnumber, items.expirationdate FROM itemshelfs JOIN items ON items.id = itemshelfs.itemid \n" +
                "JOIN shelfs ON itemshelfs.shelfid = shelfs.id \n" +
                "JOIN boxes ON shelfs.boxid = boxes.id";
        return sessionFactory.getCurrentSession().createSQLQuery(sql).list();

    }
}

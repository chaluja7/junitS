package cz.cvut.junit.dao;

import cz.cvut.junit.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.junit.entity.CoolingType;
import cz.cvut.junit.entity.ItemShelfConnection;
import org.hibernate.Query;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
@SuppressWarnings("JpaQueryApiInspection")
public class HibernateItemShelfConnectionDao extends AbstractGenericHibernateDao<ItemShelfConnection> {

    public HibernateItemShelfConnectionDao() {
        super(ItemShelfConnection.class);
    }

    public List<ItemShelfConnection> findByShelfNumber(String shelfNumber) {
        return sessionFactory.getCurrentSession().getNamedQuery("ItemShelfConnection.findByShelfNumber").setParameter("shelfNumber", shelfNumber).list();
    }

    public List<ItemShelfConnection> findByItemType(String type) {
        return sessionFactory.getCurrentSession().getNamedQuery("ItemShelfConnection.findByItemType").setParameter("type", type).list();
    }

    public List<ItemShelfConnection> getConnectionsToUnload(String itemType, CoolingType coolingType, Integer daysDurability) {

        String queryString = "select distinct c from ItemShelfConnection c inner join fetch c.item left outer join c.shelf left outer join c.shelf.box where c.item.type = :type and c.item.isFrozen = :isFrozen";
        if(daysDurability != null) {
            queryString += " and c.item.expirationDate >= :expirationDate";
        }

        queryString += " order by c.item.expirationDate";

        Query query = sessionFactory.getCurrentSession().createQuery(queryString);
        query.setParameter("type", itemType);
        query.setParameter("isFrozen", CoolingType.FREEZING.equals(coolingType) ? true : false);

        if(daysDurability != null) {
            LocalDate localDate = new LocalDate();
            localDate.plusDays(daysDurability);
            query.setParameter("expirationDate", localDate.toDate());
        }

        List<ItemShelfConnection> list = query.list();

        return list;
    }

}

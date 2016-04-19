package cz.cvut.junit.dao;

import cz.cvut.junit.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.junit.entity.ItemShelfConnection;
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

}

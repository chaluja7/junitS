package cz.cvut.junit.dao;

import cz.cvut.junit.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.junit.entity.Item;
import org.springframework.stereotype.Repository;

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

}

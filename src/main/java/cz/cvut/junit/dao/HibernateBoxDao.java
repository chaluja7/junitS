package cz.cvut.junit.dao;

import cz.cvut.junit.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.junit.entity.Box;
import org.springframework.stereotype.Repository;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
@SuppressWarnings("JpaQueryApiInspection")
public class HibernateBoxDao extends AbstractGenericHibernateDao<Box> {

    public HibernateBoxDao() {
        super(Box.class);
    }

    public Box findByNumber(Long number) {
        return (Box) sessionFactory.getCurrentSession().getNamedQuery("Box.findByNumber").setParameter("boxNumber", number).uniqueResult();
    }

}

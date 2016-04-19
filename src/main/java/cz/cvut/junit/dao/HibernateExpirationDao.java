package cz.cvut.junit.dao;

import cz.cvut.junit.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.junit.entity.Expiration;
import cz.cvut.junit.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
@SuppressWarnings("JpaQueryApiInspection")
public class HibernateExpirationDao extends AbstractGenericHibernateDao<Expiration> {

    public HibernateExpirationDao() {
        super(Expiration.class);
    }

}

package cz.cvut.junit.dao;

import cz.cvut.junit.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.junit.entity.Box;
import cz.cvut.junit.entity.Config;
import org.springframework.stereotype.Repository;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
@SuppressWarnings("JpaQueryApiInspection")
public class HibernateConfigDao extends AbstractGenericHibernateDao<Config> {

    public HibernateConfigDao() {
        super(Config.class);
    }

    public Config getConfig() {
        return (Config) sessionFactory.getCurrentSession().getNamedQuery("Config.getConfigs").setMaxResults(1).uniqueResult();
    }

}

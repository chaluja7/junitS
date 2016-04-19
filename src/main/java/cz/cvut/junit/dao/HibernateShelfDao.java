package cz.cvut.junit.dao;

import cz.cvut.junit.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.junit.entity.Shelf;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
@SuppressWarnings("JpaQueryApiInspection")
public class HibernateShelfDao extends AbstractGenericHibernateDao<Shelf> {

    public HibernateShelfDao() {
        super(Shelf.class);
    }

    public Shelf findByShelfNumberAndBoxNumber(String shelfNumber, Long boxNumber) {
        return (Shelf) sessionFactory.getCurrentSession().getNamedQuery("Shelf.findByNumberAndBoxNumber").setParameter("shelfNumber", shelfNumber).setParameter("boxNumber", boxNumber).uniqueResult();
    }

    /**
     * najde polici, kam se vejde dany pocet polozek
     * @param minimumCapacity
     * @return
     */
    public Shelf findShelfForGivenCapacity(int minimumCapacity) {
        List list = sessionFactory.getCurrentSession().createQuery("from Shelf s left join s.itemShelfConnections").list();



        return (Shelf) list.get(0);
    }

}

package cz.cvut.junit.dao;

import cz.cvut.junit.dao.generics.AbstractGenericHibernateDao;
import cz.cvut.junit.entity.Person;
import org.springframework.stereotype.Repository;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Repository
@SuppressWarnings("JpaQueryApiInspection")
public class HibernatePersonDao extends AbstractGenericHibernateDao<Person> {

    public HibernatePersonDao() {
        super(Person.class);
    }

    public Person findPersonByToken(String token) {
        return (Person) sessionFactory.getCurrentSession().getNamedQuery("Person.findPersonByToken").setParameter("token", token).uniqueResult();
    }

}

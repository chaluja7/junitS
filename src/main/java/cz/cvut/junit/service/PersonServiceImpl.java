package cz.cvut.junit.service;

import cz.cvut.junit.dao.HibernatePersonDao;
import cz.cvut.junit.entity.Person;
import cz.cvut.junit.security.HashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    protected HibernatePersonDao hibernatePersonDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Person findPerson(long id) {
        return hibernatePersonDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Person findPersonByToken(String token) {
        // TODO hashovat token
        String tokenHashed = HashUtils.getHash(token, HashUtils.SHA);
        return hibernatePersonDao.findPersonByToken(tokenHashed);
    }

    @Override
    @Transactional
    public void persistPerson(Person person) {
        // TODO hashovat token
        String tokenHashed = HashUtils.getHash(person.getToken(), HashUtils.SHA);
        person.setToken(tokenHashed);
        hibernatePersonDao.persist(person);
    }

    @Override
    @Transactional
    public void mergePerson(Person person) {
        hibernatePersonDao.merge(person);
    }

    @Override
    @Transactional
    public void deletePerson(long id) {
        hibernatePersonDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Person> findAllPersons() {
        return hibernatePersonDao.findAll();
    }

}

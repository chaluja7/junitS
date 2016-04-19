package cz.cvut.junit.service;

import cz.cvut.junit.dao.HibernateExpirationDao;
import cz.cvut.junit.entity.Expiration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sange on 19/04/16.
 */
@Service
public class ExpirationServiceImpl implements ExpirationService {

    private HashMap<String, Integer> meatExpirationDays;

    @Autowired
    protected HibernateExpirationDao hibernateExpirationDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public HashMap<String, Integer> findAll() {

        if(meatExpirationDays == null) {
            meatExpirationDays = new HashMap<>();
        }

        List<Expiration> expirations = hibernateExpirationDao.findAll();
        for (Expiration e : expirations) {
            meatExpirationDays.put(e.getItemType(), e.getExpirationDays());
        }

        return meatExpirationDays;
    }
}

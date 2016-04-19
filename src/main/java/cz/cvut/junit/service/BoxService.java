package cz.cvut.junit.service;


import cz.cvut.junit.entity.Box;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public interface BoxService {

    Box find(long id);

    Box findByNumber(long number);

    void persist(Box box);

    void merge(Box box);

    void delete(long id);

    List<Box> findAll();

}

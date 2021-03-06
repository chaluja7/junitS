package cz.cvut.junit.service;


import cz.cvut.junit.entity.Item;

import java.util.Date;
import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public interface ItemService {

    Item find(long id);

    List<Item> findByType(String type);

    List<Item> findExpiredItems();

    void deleteItems(List<Item> list);

    List getItemsPlaces(List<Item> items);

    List getItemsByType(String meatType, String coolingType);

    void persist(Item item);

    void merge(Item item);

    void delete(long id);

    Item createItemObject(String type, boolean isFrozen, Date killDate);

    List<Item> findAll();

}

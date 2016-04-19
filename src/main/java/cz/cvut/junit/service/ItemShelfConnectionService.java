package cz.cvut.junit.service;


import cz.cvut.junit.entity.CoolingType;
import cz.cvut.junit.entity.ItemShelfConnection;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public interface ItemShelfConnectionService {

    ItemShelfConnection find(long id);

    List<ItemShelfConnection> findByShelfNumber(String shelfNumber);

    List<ItemShelfConnection> findByItemType(String type);

    void persist(ItemShelfConnection itemShelfConnection);

    void merge(ItemShelfConnection itemShelfConnection);

    void delete(long id);

    List<ItemShelfConnection> findAll();

    List<ItemShelfConnection> getConnectionsToUnload(String itemType, int count, CoolingType coolingType, Integer daysDurability);

}

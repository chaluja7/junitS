package cz.cvut.junit.service;


import cz.cvut.junit.entity.CoolingType;
import cz.cvut.junit.entity.Shelf;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public interface ShelfService {

    Shelf find(long id);

    Shelf findByShelfNumberAndBoxNumber(String shelfNumber, Long boxNumber);

    void persist(Shelf shelf);

    void merge(Shelf shelf);

    void delete(long id);

    List<Shelf> findAll();

    /**
     * najde police, kam ulozime polozky - idealne jednu, ale kdyby takova nebyla tak jich vrati vic
     * @param minimumCapacity
     * @return
     */
    List<Shelf> findEmptyShelfs(int minimumCapacity, CoolingType coolingType);

}

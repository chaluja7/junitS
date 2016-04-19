package cz.cvut.junit.service;

import cz.cvut.junit.entity.Box;
import cz.cvut.junit.entity.CoolingType;
import cz.cvut.junit.entity.Shelf;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jakubchalupa
 * @since 19.04.16
 */
public class ShelfServiceTest extends AbstractServiceTest {

    @Autowired
    protected ShelfService shelfService;

    @Autowired
    protected BoxService boxService;

    @Test
    public void testShelfCrud() {
        Box box = BoxServiceTest.getBox(999980l, CoolingType.COOLING);
        boxService.persist(box);
        box = boxService.find(box.getId());
        Shelf shelf = getShelf("kxxx4", 5, box);

        shelfService.persist(shelf);

        Shelf retrievedShelf = shelfService.findByShelfNumberAndBoxNumber(shelf.getShelfNumber(), box.getBoxNumber());
        Assert.assertNotNull(retrievedShelf);

        shelfService.delete(shelf.getId());
        retrievedShelf = shelfService.find(shelf.getId());
        Assert.assertNull(retrievedShelf);

        boxService.delete(box.getId());
    }

    public static Shelf getShelf(String shelfNumber, Integer capacity, Box box) {
        Shelf shelf = new Shelf();
        shelf.setShelfNumber(shelfNumber);
        shelf.setCapacity(capacity);
        shelf.setBox(box);

        return shelf;
    }

}

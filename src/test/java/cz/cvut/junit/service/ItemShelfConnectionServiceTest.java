package cz.cvut.junit.service;

import cz.cvut.junit.entity.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.04.16
 */
public class ItemShelfConnectionServiceTest extends AbstractServiceTest {

    @Autowired
    protected ItemShelfConnectionService itemShelfConnectionService;

    @Autowired
    protected ShelfService shelfService;

    @Autowired
    protected ItemService itemService;

    @Autowired
    protected BoxService boxService;

    @Test
    public void testItemShelfConnectionCrud() {
        Box box = BoxServiceTest.getBox(1l, CoolingType.COOLING);
        boxService.persist(box);

        Shelf shelf = ShelfServiceTest.getShelf("kk4", 500, box);
        shelfService.persist(shelf);

        Item item = itemService.createItemObject("BACON", false, new Date());
        itemService.persist(item);

        ItemShelfConnection itemShelfConnection = getItemShelfConnection(item, shelf, 100);
        itemShelfConnectionService.persist(itemShelfConnection);

        ItemShelfConnection retrieved = itemShelfConnectionService.find(itemShelfConnection.getId());
        Assert.assertNotNull(retrieved);
        Assert.assertNotNull(retrieved.getItem());
        Assert.assertNotNull(retrieved.getShelf());
        Assert.assertNotNull(retrieved.getCount());

        List<ItemShelfConnection> byItemType = itemShelfConnectionService.findByItemType("BACON");
        Assert.assertNotNull(byItemType);
        Assert.assertEquals(1, byItemType.size());

        List<ItemShelfConnection> kk4 = itemShelfConnectionService.findByShelfNumber("kk4");
        Assert.assertNotNull(kk4);
        Assert.assertEquals(1, kk4.size());

        boxService.delete(box.getId());
        itemService.delete(item.getId());
    }

    public static ItemShelfConnection getItemShelfConnection(Item item, Shelf shelf, Integer count) {
        ItemShelfConnection itemShelfConnection = new ItemShelfConnection();
        itemShelfConnection.setItem(item);
        itemShelfConnection.setShelf(shelf);
        itemShelfConnection.setCount(count);

        return itemShelfConnection;
    }

}

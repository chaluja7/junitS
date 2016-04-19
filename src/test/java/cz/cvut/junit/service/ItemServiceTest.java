package cz.cvut.junit.service;

import cz.cvut.junit.entity.Item;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author jakubchalupa
 * @since 19.04.16
 */
public class ItemServiceTest extends AbstractServiceTest {

    @Autowired
    protected ItemService itemService;

    @Test
    public void testItemCrud() {
        Item item = getItem("ALLIGATOR", true, new Date());

        itemService.persist(item);

        Item retrievedItem = itemService.find(item.getId());
        Assert.assertNotNull(retrievedItem);

        itemService.delete(item.getId());
        retrievedItem = itemService.find(item.getId());
        Assert.assertNull(retrievedItem);
    }

    public static Item getItem(String type, boolean isFrozen, Date killDate) {
        Item item = new Item();
        item.setType(type);
        item.setFrozen(isFrozen);
        item.setKillDate(killDate);

        return item;
    }

}

package cz.cvut.junit.service;

import cz.cvut.junit.entity.Item;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.04.16
 */
public class ItemServiceTest extends AbstractServiceTest {

    @Autowired
    protected ItemService itemService;

    @Test
    public void testItemCrud() {
        Item item = itemService.createItemObject("ALLIGATOR", true, new Date());

        itemService.persist(item);

        Item retrievedItem = itemService.find(item.getId());
        Assert.assertNotNull(retrievedItem);

        itemService.delete(item.getId());
        retrievedItem = itemService.find(item.getId());
        Assert.assertNull(retrievedItem);
    }

    @Test
    public void testFindExpiredItems(){
        //TODO:
        List<Item> expiredItems = itemService.findExpiredItems();
        for(Item i:expiredItems){
            System.out.println(i);
        }
    }

}

package cz.cvut.junit.service;

import cz.cvut.junit.entity.Box;
import cz.cvut.junit.entity.CoolingType;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jakubchalupa
 * @since 19.04.16
 */
public class BoxServiceTest extends AbstractServiceTest {

    @Autowired
    protected BoxService boxService;

    @Test
    public void testItemCrud() {
        Box box = getBox(1l, CoolingType.COOLING);

        boxService.persist(box);

        Box retrievedBox = boxService.findByNumber(box.getBoxNumber());
        Assert.assertNotNull(retrievedBox);

        boxService.delete(box.getId());
        retrievedBox = boxService.find(box.getId());
        Assert.assertNull(retrievedBox);
    }

    public static Box getBox(Long boxNumber, CoolingType type) {
        Box box = new Box();
        box.setBoxNumber(boxNumber);
        box.setCoolingType(type);

        return box;
    }

}

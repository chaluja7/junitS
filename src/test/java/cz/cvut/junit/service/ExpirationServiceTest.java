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
public class ExpirationServiceTest extends AbstractServiceTest {

    @Autowired
    protected ExpirationService expirationService;


    @Test
    public void testSomeExpirations() {
        Assert.assertEquals(new Integer(60), expirationService.findAll().get("GOAT"));
        Assert.assertEquals(new Integer(71), expirationService.findAll().get("GOOSE"));
        Assert.assertEquals(new Integer(45), expirationService.findAll().get("GROUSE"));
    }


}

package cz.cvut.junit.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static net.javacrumbs.jsonunit.JsonAssert.assertJsonEquals;

/**
 * Created by dacos on 19.4.16.
 */
public class WarehouseManageImplTest {

    @Autowired
    protected WarehouseManageService warehouseManageService;

    @Test
    public void testGetLocationOfItemInWarehouse() throws Exception {
        assertJsonEquals("{\"key1\":1 , \"key2\":2}", "{\"key2\":2 , \"key1\":1}");

    }

    @Test
    public void testGetPickingItemFromWarehouseByMeatType() throws Exception {

    }

    @Test
    public void testPreparationShipmentOfMeat() throws Exception {

    }

    @Test
    public void testPutItemInStock() throws Exception {

    }

    @Test
    public void testReceivingShipments() throws Exception {

    }

    @Test
    public void testGenerateReportOnCurrentState() throws Exception {

    }

    @Test
    public void testEjectionItems() throws Exception {

    }

    @Test
    public void testMoveItem() throws Exception {

    }

    @Test
    public void testEmptyCoolingBoxForCleaning() throws Exception {

    }
}
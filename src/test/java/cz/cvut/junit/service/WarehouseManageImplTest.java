package cz.cvut.junit.service;

import net.javacrumbs.jsonunit.core.Option;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static net.javacrumbs.jsonunit.JsonAssert.assertJsonEquals;
import static net.javacrumbs.jsonunit.JsonAssert.when;

/**
 * Created by dacos on 19.4.16.
 */
public class WarehouseManageImplTest extends AbstractServiceTest {

    @Autowired
    protected WarehouseManageService warehouseManageService;

    @Test
    public void testGetLocationOfItemInWarehouse() throws Exception {
        assertJsonEquals(warehouseManageService.getLocationOfItemInWarehouse("{\"key1\":1 , \"key2\":2}"), "{\"key2\":2 , \"key1\":1}");
        assertJsonEquals("[{\"test\":1}, {\"test\":2}]",
                "[{\n\"test\": 2\n}, {\"test\": 1}]",when(Option.IGNORING_ARRAY_ORDER));
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
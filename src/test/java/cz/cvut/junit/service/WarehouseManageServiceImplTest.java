package cz.cvut.junit.service;

import cz.cvut.junit.util.Util;
import cz.cvut.junit.web.wrapper.output.ItemPlace;
import cz.cvut.junit.web.wrapper.output.ItemPlacesResponse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

/**
 * Created by dacos on 19.4.16.
 */
public class WarehouseManageServiceImplTest extends AbstractServiceTest {

    @Autowired
    protected WarehouseManageService warehouseManageService;

    @Test
    public void testGetLocationOfItemInWarehouse() throws Exception {
//        assertJsonEquals(warehouseManageService.getLocationOfItemInWarehouse("{\"key1\":1 , \"key2\":2}"), "{\"key2\":2 , \"key1\":1}");
//        assertJsonEquals("[{\"test\":1}, {\"test\":2}]",
//                "[{\n\"test\": 2\n}, {\"test\": 1}]",when(Option.IGNORING_ARRAY_ORDER));

        String s = Util.readFile(new File(getClass().getClassLoader().getResource("testJson/store1.json").getFile()));
        warehouseManageService.putItemInStock(s);
        s = warehouseManageService.getLocationOfItemInWarehouse("{ \"type\" : \"PORK\", \"cooling-type\" : \"COOLING\" }");
        System.out.println(s);


    }

    @Test
    public void testGetPickingItemFromWarehouseByMeatType() throws Exception {

    }

    @Test
    public void testPreparationShipmentOfMeat() throws Exception {

    }

    @Test
    public void testPutItemInStock() throws Exception {
        String s = Util.readFile(new File(getClass().getClassLoader().getResource("testJson/store1.json").getFile()));
        String s1 = warehouseManageService.putItemInStock(s);
        Assert.assertNotNull(s1);
    }

    @Test
    public void testReceivingShipments() throws Exception {

    }

    @Test
    public void testGenerateReportOnCurrentState() throws Exception {

    }

    @Test
    public void testEjectionItems() throws Exception {
        warehouseManageService.putItemInStock("{ \"type\" : \"PORK\", \"count\" : 84, \"date-of-slaughter\" : \"25.02.2015\", \"is-frozen\" : false }");
        String ss = warehouseManageService.ejectionItems();
        System.out.println(ss);

    }

    @Test
    public void testMoveItem() throws Exception {

    }

    @Test
    public void testEmptyCoolingBoxForCleaning() throws Exception {

    }
}
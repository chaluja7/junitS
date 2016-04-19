package cz.cvut.junit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.junit.entity.Config;
import cz.cvut.junit.util.Util;
import cz.cvut.junit.web.wrapper.init.WarehouseInit;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static net.javacrumbs.jsonunit.JsonAssert.assertJsonEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by frox on 19.4.16.
 */
public class WarehouseConfigurationServiceImplTest extends AbstractServiceTest{

    @Autowired
    protected WarehouseConfigurationService warehouseConfigurationService;

    @Autowired
    protected ConfigService configService;

    @Test
    public void testInitializateWarehouseInit1() throws Exception {
        WarehouseInit warehouseInit1 = createWarehouse("init1.json");
        assertEquals(25, warehouseInit1.getWarehouse().getCoolingBoxes().size());
        assertEquals("Maso Slany s.r.o.",warehouseInit1.getCompany().getName());
        assertJsonEquals("{\"name\":\"Maso Slany s.r.o.\"}",Util.createJsonFromObject(warehouseInit1.getCompany()));
        System.out.println(Util.createJsonFromObject(warehouseInit1.getCompany()));
    }

    @Test
    @Ignore
    public void testInitializateWarehouseWithData() {
        String s = Util.readFile(new File(getClass().getClassLoader().getResource("testJson/init1.json").getFile()));
        warehouseConfigurationService.initializateWarehouse(s);
    }

    @Test
    public void testInitializateWarehouseInit2() throws Exception {
        WarehouseInit warehouseInit2 =  createWarehouse("init2.json");
        assertEquals(30, warehouseInit2.getWarehouse().getCoolingBoxes().size());
        assertEquals("Maso Slany s.r.o.", warehouseInit2.getCompany().getName());
        assertJsonEquals("{\"name\":\"Maso Slany s.r.o.\"}",Util.createJsonFromObject(warehouseInit2.getCompany()));
        System.out.println(Util.createJsonFromObject(warehouseInit2.getCompany()));
    }

    private WarehouseInit createWarehouse(String jsonFileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("testJson/"+jsonFileName).getFile());
        return (WarehouseInit)Util.createObjectFromJson(Util.readFile(file), WarehouseInit.class);
    }

    @Test
    public void testShiftWarehouseSystemDate() throws Exception {

    }

    @Test
    public void testInitializateWarehouse() throws Exception {

    }

    @Test
    public void testShiftWarehouseSystemDate1() throws Exception {
        Config config = configService.getConfig();
        Date tomorrow = new DateTime(config.getDate()).plusDays(1).toDate();
        warehouseConfigurationService.shiftWarehouseSystemDate();
        config = configService.getConfig();
        Assert.assertEquals(tomorrow,config.getDate());

    }
}
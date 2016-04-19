package cz.cvut.junit.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.junit.util.Util;
import cz.cvut.junit.web.wrapper.init.WarehouseInit;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static net.javacrumbs.jsonunit.JsonAssert.assertJsonEquals;
import static org.junit.Assert.*;

/**
 * Created by frox on 19.4.16.
 */
public class WarehouseConfigurationImplTest {

    @Autowired
    protected WarehouseConfigurationService warehouseConfigurationService;

    @Test
    public void testInitializateWarehouseInit1() throws Exception {
        WarehouseInit warehouseInit1 =  createWarehouse("init1.json");
        assertEquals(25, warehouseInit1.getWarehouse().getCoolingBoxes().size());
        assertEquals("Maso Slany s.r.o.",warehouseInit1.getCompany().getName());
        assertJsonEquals("{\"name\":\"Maso Slany s.r.o.\"}",Util.createJsonFromObject(warehouseInit1.getCompany()));
        System.out.println(Util.createJsonFromObject(warehouseInit1.getCompany()));
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
}
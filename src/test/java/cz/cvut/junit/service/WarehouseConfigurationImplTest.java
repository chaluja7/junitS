package cz.cvut.junit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.junit.util.Util;
import cz.cvut.junit.web.wrapper.init.WarehouseInit;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by frox on 19.4.16.
 */
public class WarehouseConfigurationImplTest {

    @Autowired
    protected WarehouseConfigurationService warehouseConfigurationService;

    @Test
    public void testInitializateWarehouse() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("testJson/init1.json").getFile());
        WarehouseInit warehouseInit = mapper.readValue(file, WarehouseInit.class);
        assertEquals(25, warehouseInit.getWarehouse().getCoolingBoxes().size());

    }

    @Test
    public void testShiftWarehouseSystemDate() throws Exception {

    }
}
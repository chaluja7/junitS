package cz.cvut.junit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.junit.web.wrapper.init.WarehouseInit;

import java.io.IOException;

/**
 * Created by dacos on 19.4.16.
 */
public class WarehouseConfigurationImpl implements WarehouseConfigurationService {

    @Override
    public void initializateWarehouse(String inputJson) {
        ObjectMapper mapper = new ObjectMapper();
        WarehouseInit warehouseInit;
        try {
            warehouseInit= mapper.readValue(inputJson, WarehouseInit.class);
            System.out.println(warehouseInit);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void shiftWarehouseSystemDate() {
        //empty
    }
}

package cz.cvut.junit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.junit.entity.Config;
import cz.cvut.junit.web.wrapper.init.WarehouseInit;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by dacos on 19.4.16.
 */
@Service
public class WarehouseConfigurationImpl implements WarehouseConfigurationService {

    @Autowired
    protected ConfigService configService;

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
        Config config = configService.getConfig();
        config.setDate(new DateTime(config.getDate()).plusDays(1).toDate());
        configService.merge(config);
    }
}

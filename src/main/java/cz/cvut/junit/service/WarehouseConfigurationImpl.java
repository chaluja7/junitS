package cz.cvut.junit.service;

import cz.cvut.junit.entity.Box;
import cz.cvut.junit.entity.Config;
import cz.cvut.junit.entity.Shelf;
import cz.cvut.junit.util.Util;
import cz.cvut.junit.web.wrapper.init.BoxWrapper;
import cz.cvut.junit.web.wrapper.init.ShelfWrapper;
import cz.cvut.junit.web.wrapper.init.WarehouseInit;
import cz.cvut.junit.web.wrapper.init.WarehouseWrapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by dacos on 19.4.16.
 */
@Service
public class WarehouseConfigurationImpl implements WarehouseConfigurationService {

    @Autowired
    protected ConfigService configService;

    @Autowired
    protected BoxService boxService;

    @Override
    public void initializateWarehouse(String inputJson) {
        WarehouseInit warehouseInit;
        try {
            warehouseInit = (WarehouseInit) Util.createObjectFromJson(inputJson, WarehouseInit.class);

            WarehouseWrapper warehouse = warehouseInit.getWarehouse();
            if(warehouse != null) {
                List<BoxWrapper> coolingBoxes = warehouse.getCoolingBoxes();
                if(coolingBoxes != null) {
                    for(BoxWrapper coolingBox : coolingBoxes) {
                        Box box = getBoxFromBoxWrapper(coolingBox);
                        boxService.persist(box);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Box getBoxFromBoxWrapper(BoxWrapper boxWrapper) {
        if(boxWrapper == null) return null;

        Box box = new Box();
        box.setBoxNumber(boxWrapper.getNumber());
        box.setCoolingType(boxWrapper.getType());

        List<ShelfWrapper> shelfs = boxWrapper.getShelfs();
        if(shelfs != null) {
            for(ShelfWrapper shelf : shelfs) {
                box.addShelf(getShelfFromShelfWrapper(shelf));
            }
        }

        return box;
    }

    private Shelf getShelfFromShelfWrapper(ShelfWrapper shelfWrapper) {
        if(shelfWrapper == null) return null;

        Shelf shelf = new Shelf();
        shelf.setShelfNumber(shelfWrapper.getNumber());
        shelf.setCapacity(shelfWrapper.getCapacity());

        return shelf;
    }

    @Override
    public void shiftWarehouseSystemDate() {
        Config config = configService.getConfig();
        config.setDate(new DateTime(config.getDate()).plusDays(1).toDate());
        configService.merge(config);
    }
}

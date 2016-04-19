package cz.cvut.junit.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dacos on 19.4.16.
 */
@Service
public class WarehouseManageImpl implements WarehouseManageService {

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public String getLocationOfItemInWarehouse(String inputJson) {
        return inputJson;
    }

    @Override
    @Transactional
    public String getPickingItemFromWarehouseByMeatType(String inputJson) {
        return null;
    }

    //nepovinne
    @Override
    @Transactional
    public String preparationShipmentOfMeat(String inputJson) {
        return null;
    }

    @Override
    @Transactional
    public String putItemInStock(String inputJson) {
        return null;
    }

    //nepovinne
    @Override
    @Transactional
    public String receivingShipments(String inputJson) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public byte[] generateReportOnCurrentState() {
        return new byte[0];
    }

    //nepovinne
    @Override
    @Transactional
    public String ejectionItems() {
        return null;
    }

    //nepovinne
    @Override
    @Transactional
    public void moveItem(String inputJson) {

    }

    //nepovinne
    @Override
    @Transactional
    public void emptyCoolingBoxForCleaning(String inputJson) {

    }
}

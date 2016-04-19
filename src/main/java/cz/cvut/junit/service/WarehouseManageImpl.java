package cz.cvut.junit.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import cz.cvut.junit.entity.Item;
import cz.cvut.junit.util.Util;
import cz.cvut.junit.web.wrapper.input.ItemPlacesRequest;
import cz.cvut.junit.web.wrapper.input.StoreItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Created by dacos on 19.4.16.
 */
@Service
public class WarehouseManageImpl implements WarehouseManageService {

    @Autowired
    protected ItemService itemService;

    @Autowired
    protected ShelfService shelfService;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public String getLocationOfItemInWarehouse(String inputJson) {
        try {
            ItemPlacesRequest itemPlaceRequest = (ItemPlacesRequest) Util.createObjectFromJson(inputJson, ItemPlacesRequest.class);
            itemPlaceRequest.getCoolingType();
            itemPlaceRequest.getType();





        } catch (IOException e) {
            e.printStackTrace();
        }

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
        try {
            StoreItemRequest storeItemRequest = (StoreItemRequest) Util.createObjectFromJson(inputJson, StoreItemRequest.class);

            Item item = new Item();
            item.setType(storeItemRequest.getType());
            item.setKillDate(Util.getDateFromCsFormat(storeItemRequest.getDateOfSlaughter()));
            item.setFrozen(storeItemRequest.isFrozen());

            itemService.persist(item);

            //TODO pridat umisteni do polic
            //vybrat volne police





        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputJson;


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
        try {
            return Util.createJsonFromObject(itemService.deleteExpiredItems());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
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

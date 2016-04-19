package cz.cvut.junit.service;

import cz.cvut.junit.entity.Item;
import cz.cvut.junit.entity.ItemShelfConnection;
import cz.cvut.junit.entity.Shelf;
import cz.cvut.junit.pojo.ReportItem;
import cz.cvut.junit.util.Util;
import cz.cvut.junit.web.wrapper.input.ItemPlacesRequest;
import cz.cvut.junit.web.wrapper.input.StoreItemRequest;
import cz.cvut.junit.web.wrapper.output.ItemPlace;
import cz.cvut.junit.web.wrapper.output.ItemPlacesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dacos on 19.4.16.
 */
@Service
public class WarehouseManageImpl implements WarehouseManageService {

    @Autowired
    protected ItemService itemService;

    @Autowired
    protected ShelfService shelfService;

    @Autowired
    protected ItemShelfConnectionService itemShelfConnectionService;

    @Autowired
    protected ReportService reportService;

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

    private ItemPlace getItemPlaceFromShelf(Shelf shelf, int count) {
        ItemPlace itemPlace = new ItemPlace();
        itemPlace.setShelfNumber(shelf.getShelfNumber());
        itemPlace.setCount(count);
        itemPlace.setBoxNumber(shelf.getBox().getBoxNumber());

        return itemPlace;
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
            List<Shelf> emptyShelfs = shelfService.findEmptyShelfs(storeItemRequest.getCount());
            if(emptyShelfs == null || emptyShelfs.isEmpty()) {
                throw new RuntimeException("not enough space on shelfs!");
            }


            ItemPlacesResponse<ItemPlace> itemPlaceItemPlacesResponse = new ItemPlacesResponse<>();
            List<ItemPlace> itemPlaceList = new ArrayList<>();
            itemPlaceItemPlacesResponse.setItemPlace(itemPlaceList);

            if(emptyShelfs.size() == 1) {
                //single shelf
                ItemShelfConnection itemShelfConnection = new ItemShelfConnection();
                itemShelfConnection.setCount(storeItemRequest.getCount());
                itemShelfConnection.setItem(item);
                itemShelfConnection.setShelf(emptyShelfs.get(0));

                itemShelfConnectionService.persist(itemShelfConnection);

                ItemPlace itemPlace = getItemPlaceFromShelf(emptyShelfs.get(0), storeItemRequest.getCount());
                itemPlaceList.add(itemPlace);

            } else {
                int alreadyStored = 0;
                for(Shelf emptyShelf : emptyShelfs) {
                    ItemShelfConnection itemShelfConnection = new ItemShelfConnection();

                    itemShelfConnection.setCount(Math.min(storeItemRequest.getCount(), emptyShelf.getFreeCapacity()));
                    itemShelfConnection.setItem(item);
                    itemShelfConnection.setShelf(emptyShelf);

                    ItemPlace itemPlace = getItemPlaceFromShelf(emptyShelfs.get(0), Math.max(emptyShelf.getCapacity(), storeItemRequest.getCount() - alreadyStored));
                    itemPlaceList.add(itemPlace);
                    alreadyStored += emptyShelf.getFreeCapacity();

                    itemShelfConnectionService.persist(itemShelfConnection);
                }
            }

            return Util.createJsonFromObject(itemPlaceItemPlacesResponse);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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
        List<ReportItem> reportItems = reportService.findAll();

        StringBuilder sb = new StringBuilder();
        for (ReportItem reportItem : reportItems) {

            sb.append(reportItem.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString().getBytes();
    }

    //nepovinne
    @Override
    @Transactional
    public String ejectionItems() {
        List<Item> itemsToDelete = itemService.findExpiredItems();
        List itemPlaces = itemService.getItemsPlaces(itemsToDelete);
        itemService.deleteItems(itemsToDelete);
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

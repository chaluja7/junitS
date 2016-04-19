package cz.cvut.junit.service;

import cz.cvut.junit.entity.Item;
import cz.cvut.junit.entity.ItemShelfConnection;
import cz.cvut.junit.pojo.ReportItem;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.ReadableInstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by sange on 19/04/16.
 */
@Service
public class ReportServiceImpl implements ReportService{

    @Autowired
    private ItemShelfConnectionService itemShelfConnectionService;

    @Autowired
    private ItemService itemService;

    private List<ReportItem> reportItems;

    @Override
    public List<ReportItem> findAll() {
        List<ItemShelfConnection> itemShelfConnections = itemShelfConnectionService.findAll();
        List<Item> items = itemService.findAll();


        if(reportItems == null){
            reportItems = new ArrayList<>();
        }

        for (Item item : items) {
            for (ItemShelfConnection isc : itemShelfConnections) {
                if(Objects.equals(isc.getItem().getId(), item.getId())){

                    ReportItem reportItem = new ReportItem();
                    reportItem.setType(item.getType());
                    reportItem.setCount(isc.getCount());
                    reportItem.setFrozen(item.getFrozen());

                    DateTime now = DateTime.now();
                    DateTime expDate = new DateTime(item.getExpirationDate());

                    // plus jedna pro inclusive
                    int expiresInDays = Days.daysBetween(now, expDate).getDays() + 1;
                    reportItem.setExpiresInDays(expiresInDays);

                    reportItems.add(reportItem);
                }
            }
        }

        return reportItems;
    }

}

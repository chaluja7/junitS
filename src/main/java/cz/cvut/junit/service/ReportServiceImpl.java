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
    private ExpirationService expirationService;

    @Autowired
    private ItemShelfConnectionService itemShelfConnectionService;

    @Autowired
    private ItemService itemService;

    private List<ReportItem> reportItems;

    @Override
    public List<ReportItem> findAll() {
        HashMap<String, Integer> expirations = expirationService.findAll();
        List<ItemShelfConnection> itemShelfConnections = itemShelfConnectionService.findAll();
        List<Item> items = itemService.findAll();


        if(reportItems == null){
            reportItems = new ArrayList<>();
        }

        for (Item item : items) {
            for (ItemShelfConnection isc : itemShelfConnections) {
                for (Map.Entry<String, Integer> e : expirations.entrySet()) {
                    String type = e.getKey();
                    int expirationDays = e.getValue();
                    if(isc.getItem() == item && Objects.equals(item.getType(), type)){

                        ReportItem reportItem = new ReportItem();
                        reportItem.setType(type);
                        reportItem.setCount(isc.getCount());
                        reportItem.setFrozen(item.getFrozen());

                        DateTime now = DateTime.now();
                        DateTime killTime = new DateTime(item.getKillDate());

                        int expiresInDays = Days.daysBetween(killTime.plusDays(expirationDays), now).getDays();;
                        reportItem.setExpiresInDays(expiresInDays);

                        reportItems.add(reportItem);
                    }

                }
            }
        }

        return null;
    }

}

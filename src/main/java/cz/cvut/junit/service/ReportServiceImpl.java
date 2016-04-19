package cz.cvut.junit.service;

import cz.cvut.junit.entity.ItemShelfConnection;
import cz.cvut.junit.pojo.ReportItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by sange on 19/04/16.
 */
@Service
public class ReportServiceImpl implements ReportService{

    @Autowired
    private ExpirationService expirationService;

    @Autowired
    private ItemShelfConnectionService itemShelfConnectionService;

    @Override
    public List<ReportItem> findAll() {
        HashMap<String, Integer> expirationServiceAll = expirationService.findAll();
        List<ItemShelfConnection> itemShelfConnections = itemShelfConnectionService.findAll();

        return null;
    }
}

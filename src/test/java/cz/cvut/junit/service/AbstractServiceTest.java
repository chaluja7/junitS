package cz.cvut.junit.service;

import cz.cvut.junit.util.Util;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

/**
 * Abstract service test.
 *
 * @author jakubchalupa
 * @since 19.03.16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
//@Rollback
//@Transactional(transactionManager = "transactionManager")
public abstract class AbstractServiceTest {

    @Autowired
    protected WarehouseConfigurationService warehouseConfigurationService;

    @Before
    public void init() {
        String s = Util.readFile(new File(getClass().getClassLoader().getResource("testJson/init1.json").getFile()));
        warehouseConfigurationService.initializateWarehouse(s);
    }

}


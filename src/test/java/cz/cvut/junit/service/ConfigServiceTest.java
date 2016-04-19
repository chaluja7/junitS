package cz.cvut.junit.service;

import cz.cvut.junit.entity.Config;
import cz.cvut.junit.util.Util;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jakubchalupa
 * @since 19.04.16
 */
public class ConfigServiceTest extends AbstractServiceTest {

    @Autowired
    protected ConfigService configService;


    public void testDefaultTime() throws ParseException {
        Date now = new Date();
        Config config = configService.getConfig();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//2016-04-19 00:00:00.0
        Assert.assertEquals(df.parse("2016-04-19"), config.getDate());
        config.setDate(now);

        configService.merge(config);

        Config retrievedConfig = configService.getConfig();
        Assert.assertNotNull(retrievedConfig);
        Assert.assertEquals(now, retrievedConfig.getDate());
    }

    @Test
    public void testDateShift() throws ParseException {
        testDefaultTime();
        DateTime dateTime = DateTime.parse("04.02.2011", DateTimeFormat.forPattern(Util.getDateTimeCsFormat()));
        Config config = configService.getConfig();
        config.setDate(dateTime.toDate());
        configService.merge(config);

        Config retrievedConfig = configService.getConfig();
        Assert.assertEquals(dateTime, new DateTime(retrievedConfig.getDate()));
        retrievedConfig.setDate(new DateTime(retrievedConfig.getDate()).plusDays(1).toDate());
        configService.merge(retrievedConfig);
//
        retrievedConfig = configService.getConfig();
        Assert.assertEquals(DateTime.parse("05.02.2011", DateTimeFormat.forPattern(Util.getDateTimeCsFormat())).toDate(), retrievedConfig.getDate());
        dateTime = new DateTime(retrievedConfig.getDate());
        dateTime.plusDays(1);
        config.setDate(dateTime.toDate());
        configService.merge(config);


    }

    public static Config getConfig(Date date) {
        Config config = new Config();
        config.setDate(date);
        return config;
    }

}

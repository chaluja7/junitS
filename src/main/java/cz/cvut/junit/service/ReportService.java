package cz.cvut.junit.service;

import cz.cvut.junit.pojo.ReportItem;

import java.util.List;

/**
 * Created by sange on 19/04/16.
 */
public interface ReportService {

    public List<ReportItem> findAll();

}

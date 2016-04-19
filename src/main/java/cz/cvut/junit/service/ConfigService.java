package cz.cvut.junit.service;


import cz.cvut.junit.entity.Box;
import cz.cvut.junit.entity.Config;

import java.util.List;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public interface ConfigService {

    Config getConfig();

    void merge(Config config);


}

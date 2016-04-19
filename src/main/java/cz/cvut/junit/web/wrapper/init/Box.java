package cz.cvut.junit.web.wrapper.init;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.cvut.junit.entity.CoolingType;

import java.util.List;

/**
 * Created by frox on 19.4.16.
 */
public class Box {
    @JsonProperty("number")
    int number;

    @JsonProperty("type")
    CoolingType type;

    @JsonProperty("shelfs")
    List<Shelf> shelfs;
}

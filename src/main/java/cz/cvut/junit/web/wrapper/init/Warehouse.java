package cz.cvut.junit.web.wrapper.init;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by frox on 19.4.16.
 */
public class Warehouse {
    @JsonProperty("serial-number")
    String serialNumber;

    @JsonProperty("cooling-boxes")
    List<Box> coolingBoxes;

}

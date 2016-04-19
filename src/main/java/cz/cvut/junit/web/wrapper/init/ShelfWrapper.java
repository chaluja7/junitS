package cz.cvut.junit.web.wrapper.init;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by frox on 19.4.16.
 */
public class ShelfWrapper {
    @JsonProperty("number")
    String number;

    @JsonProperty("capacity")
    int capacity;
}

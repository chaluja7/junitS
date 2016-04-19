package cz.cvut.junit.web.wrapper.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by frox on 19.4.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreItemRequest {

    @JsonProperty("type")
    private String type;

    @JsonProperty("count")
    private int count;

    @JsonProperty("date-of-slaughter")
    private String dateOfSlaughter;

    @JsonProperty("is-frozen")
    private boolean isFrozen;

}

package cz.cvut.junit.web.wrapper.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by frox on 19.4.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemLocationsRequest {

    @JsonProperty("type")
    private String type;

    @JsonProperty("cooling-type")
    private String coolingType;

}

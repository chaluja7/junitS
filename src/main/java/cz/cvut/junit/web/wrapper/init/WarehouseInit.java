package cz.cvut.junit.web.wrapper.init;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by frox on 19.4.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WarehouseInit {
    @JsonProperty("company")
    Company company;

    @JsonProperty("warehouse")
    Warehouse warehouse;


}

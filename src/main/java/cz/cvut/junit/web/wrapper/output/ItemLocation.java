package cz.cvut.junit.web.wrapper.output;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by frox on 19.4.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemLocation {
    @JsonProperty("box-number")
    private int boxNumber;

    @JsonProperty("shelf-number")
    private String shelfNumber;

    @JsonProperty("count")
    private int count;

    @JsonProperty("date-of-expiration")
    private String dateOfExpiration;
}

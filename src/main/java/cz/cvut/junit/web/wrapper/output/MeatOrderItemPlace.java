package cz.cvut.junit.web.wrapper.output;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sange on 19/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeatOrderItemPlace extends ItemPlace {

    @JsonProperty("date-of-expiration")
    private String dateOfExpiration;

    @JsonProperty("type")
    private String type;


    public String getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(String dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDateOfSlaughter() {
        return dateOfSlaughter;
    }

    public void setDateOfSlaughter(String dateOfSlaughter) {
        this.dateOfSlaughter = dateOfSlaughter;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }
}

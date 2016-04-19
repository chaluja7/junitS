package cz.cvut.junit.web.wrapper.output;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by frox on 19.4.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPlaceBase {
    @JsonProperty("box-number")
    private long boxNumber;

    @JsonProperty("shelf-number")
    private String shelfNumber;

    public long getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(long boxNumber) {
        this.boxNumber = boxNumber;
    }

    public String getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(String shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

}

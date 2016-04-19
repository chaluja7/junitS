package cz.cvut.junit.web.wrapper.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by frox on 19.4.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnstoreItemRequest {

    @JsonProperty("type")
    private String type;

    @JsonProperty("cooling-type")
    private String coolingType;

    @JsonProperty("count")
    private int count;

    @JsonProperty("days-durability")
    private int daysDurability;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCoolingType() {
        return coolingType;
    }

    public void setCoolingType(String coolingType) {
        this.coolingType = coolingType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDaysDurability() {
        return daysDurability;
    }

    public void setDaysDurability(int daysDurability) {
        this.daysDurability = daysDurability;
    }
}

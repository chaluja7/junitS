package cz.cvut.junit.web.wrapper.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sange on 19/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeatOrderItem {

    @JsonProperty("type")
    private String type;

    @JsonProperty("count")
    private int count;


    @JsonProperty("cooling-type")
    private String coolingType;


    @JsonProperty("days-durabilit")
    private int daysDurability;

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

    public String getCoolingType() {
        return coolingType;
    }

    public void setCoolingType(String coolingType) {
        this.coolingType = coolingType;
    }

    public int getDaysDurability() {
        return daysDurability;
    }

    public void setDaysDurability(int daysDurability) {
        this.daysDurability = daysDurability;
    }
}

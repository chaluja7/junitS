package cz.cvut.junit.web.wrapper.init;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.cvut.junit.entity.CoolingType;

import java.util.List;

/**
 * Created by frox on 19.4.16.
 */
public class BoxWrapper {
    @JsonProperty("number")
    private long number;

    @JsonProperty("type")
    private CoolingType type;

    @JsonProperty("shelfs")
    private List<ShelfWrapper> shelfs;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public CoolingType getType() {
        return type;
    }

    public void setType(CoolingType type) {
        this.type = type;
    }

    public List<ShelfWrapper> getShelfs() {
        return shelfs;
    }

    public void setShelfs(List<ShelfWrapper> shelfs) {
        this.shelfs = shelfs;
    }
}

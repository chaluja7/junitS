package cz.cvut.junit.web.wrapper.init;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import cz.cvut.junit.entity.CoolingType;

import java.util.List;

/**
 * Created by frox on 19.4.16.
 */
public class Box {
    @JsonProperty("number")
    private int number;

    @JsonProperty("type")
    private CoolingType type;

    @JsonProperty("shelfs")
    private List<Shelf> shelfs;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public CoolingType getType() {
        return type;
    }

    public void setType(CoolingType type) {
        this.type = type;
    }

    public List<Shelf> getShelfs() {
        return shelfs;
    }

    public void setShelfs(List<Shelf> shelfs) {
        this.shelfs = shelfs;
    }
}

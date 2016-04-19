package cz.cvut.junit.web.wrapper.init;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by frox on 19.4.16.
 */
public class ShelfWrapper {
    @JsonProperty("number")
    private String number;

    @JsonProperty("capacity")
    private int capacity;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

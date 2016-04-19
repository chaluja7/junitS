package cz.cvut.junit.web.wrapper.init;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by frox on 19.4.16.
 */
public class Warehouse {
    @JsonProperty("serial-number")
    private String serialNumber;

    @JsonProperty("cooling-boxes")
    private List<Box> coolingBoxes;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List<Box> getCoolingBoxes() {
        return coolingBoxes;
    }

    public void setCoolingBoxes(List<Box> coolingBoxes) {
        this.coolingBoxes = coolingBoxes;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "serialNumber='" + serialNumber + '\'' +
                ", coolingBoxes=" + coolingBoxes +
                '}';
    }
}

package cz.cvut.junit.web.wrapper.init;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by frox on 19.4.16.
 */
public class WarehouseWrapper {
    @JsonProperty("serial-number")
    private String serialNumber;

    @JsonProperty("cooling-boxes")
    private List<BoxWrapper> coolingBoxes;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List<BoxWrapper> getCoolingBoxes() {
        return coolingBoxes;
    }

    public void setCoolingBoxes(List<BoxWrapper> coolingBoxes) {
        this.coolingBoxes = coolingBoxes;
    }

    @Override
    public String toString() {
        return "WarehouseWrapper{" +
                "serialNumber='" + serialNumber + '\'' +
                ", coolingBoxes=" + coolingBoxes +
                '}';
    }
}

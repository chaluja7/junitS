package cz.cvut.junit.web.wrapper.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by sange on 19/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeatOrderRequest {

    @JsonProperty("meat-order")
    private ArrayList<MeatOrderItem> meatOrder;

    public ArrayList<MeatOrderItem> getMeatOrder() {
        return meatOrder;
    }

    public void setMeatOrder(ArrayList<MeatOrderItem> meatOrder) {
        this.meatOrder = meatOrder;
    }
}

package cz.cvut.junit.web.wrapper.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by frox on 19.4.16.
 */
public class StoreItemResponse {
    @JsonProperty("item-place")
    List<ItemLocation> itemPlace;

    public List<ItemLocation> getItemPlace() {
        return itemPlace;
    }

    public void setItemPlace(List<ItemLocation> itemPlace) {
        this.itemPlace = itemPlace;
    }
}

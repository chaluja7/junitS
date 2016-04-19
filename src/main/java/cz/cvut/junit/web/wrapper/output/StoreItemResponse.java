package cz.cvut.junit.web.wrapper.output;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by frox on 19.4.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreItemResponse {
    @JsonProperty("item-place")
    List<ItemPlace> itemPlace;

    public List<ItemPlace> getItemPlace() {
        return itemPlace;
    }

    public void setItemPlace(List<ItemPlace> itemPlace) {
        this.itemPlace = itemPlace;
    }
}

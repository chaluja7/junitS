package cz.cvut.junit.web.wrapper.output;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by frox on 19.4.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPlacesResponse {
    @JsonProperty("item-place")
    List<ItemPlaceWithExpiration> itemPlace;

    public List<ItemPlaceWithExpiration> getItemPlace() {
        return itemPlace;
    }

    public void setItemPlace(List<ItemPlaceWithExpiration> itemPlace) {
        this.itemPlace = itemPlace;
    }
}

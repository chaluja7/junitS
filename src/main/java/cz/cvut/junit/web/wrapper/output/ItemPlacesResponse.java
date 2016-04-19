package cz.cvut.junit.web.wrapper.output;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by frox on 19.4.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPlacesResponse<T> {
    @JsonProperty("item-place")
    List<T> itemPlace;

    public List<T> getItemPlace() {
        return itemPlace;
    }

    public void setItemPlace(List<T> itemPlace) {
        this.itemPlace = itemPlace;
    }
}

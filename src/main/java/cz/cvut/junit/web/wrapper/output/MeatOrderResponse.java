package cz.cvut.junit.web.wrapper.output;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by sange on 19/04/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeatOrderResponse {

    @JsonProperty("meat-order-place")
    private ArrayList<MeatOrderItemPlace> meatOrderPlace;
 }

package cz.cvut.junit.web.wrapper.init;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by frox on 19.4.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WarehouseInit {
    @JsonProperty("company")
    private Company company;

    @JsonProperty("warehouse")
    private Warehouse warehouse;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "WarehouseInit{" +
                "company=" + company +
                ", warehouse=" + warehouse +
                '}';
    }
}

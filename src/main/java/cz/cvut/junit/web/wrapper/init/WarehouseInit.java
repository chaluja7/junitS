package cz.cvut.junit.web.wrapper.init;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by frox on 19.4.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WarehouseInit {
    @JsonProperty("company")
    private CompanyWrapper company;

    @JsonProperty("warehouse")
    private WarehouseWrapper warehouse;

    public CompanyWrapper getCompany() {
        return company;
    }

    public void setCompany(CompanyWrapper company) {
        this.company = company;
    }

    public WarehouseWrapper getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseWrapper warehouse) {
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

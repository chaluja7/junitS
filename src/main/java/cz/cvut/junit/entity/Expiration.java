package cz.cvut.junit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Maso
 * @author jakubchalupa
 * @since 19.04.16
 */
@Entity
@Table(name = "expirations")
public class Expiration extends AbstractEntity {

    private static final long serialVersionUID = -3848335010623796295L;

    @Column(nullable = false, unique = true)
    private String itemType;

    @Column(nullable = false)
    private Integer expirationDays;

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getExpirationDays() {
        return expirationDays;
    }

    public void setExpirationDays(Integer expirationDays) {
        this.expirationDays = expirationDays;
    }
}

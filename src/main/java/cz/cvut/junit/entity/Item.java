package cz.cvut.junit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Maso
 * @author jakubchalupa
 * @since 19.04.16
 */
@Entity
@Table(name = "items")
public class Item extends AbstractEntity {

    private static final long serialVersionUID = 3266069159000216558L;

    @Column(nullable = false)
    private String type;

    @Column
    private Date killDate;

    @Column(nullable = false)
    private Boolean isFrozen;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getKillDate() {
        return killDate;
    }

    public void setKillDate(Date killDate) {
        this.killDate = killDate;
    }

    public Boolean getFrozen() {
        return isFrozen;
    }

    public void setFrozen(Boolean frozen) {
        isFrozen = frozen;
    }
}

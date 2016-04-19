package cz.cvut.junit.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Maso
 * @author jakubchalupa
 * @since 19.04.16
 */
@Entity
@Table(name = "items")
@NamedQueries({
    @NamedQuery(name = "Item.findByType", query = "FROM Item i WHERE i.type = :type"),
    @NamedQuery(name = "Item.findExpiredItems", query = "FROM Item i WHERE i.expirationDate = :date")

})
public class Item extends AbstractEntity {

    private static final long serialVersionUID = 3266069159000216558L;

    @Column(nullable = false)
    private String type;

    @Column
    private Date killDate;

    @Column(nullable = false)
    private Boolean isFrozen;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "item")
    private Set<ItemShelfConnection> itemShelfConnections;

    @Column
    private Date expirationDate;

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

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
        //todo: set expiration date
        this.killDate = killDate;
    }

    public Boolean getFrozen() {
        return isFrozen;
    }

    public void setFrozen(Boolean frozen) {
        isFrozen = frozen;
    }

    public Set<ItemShelfConnection> getItemShelfConnections() {
        if(itemShelfConnections == null) {
            itemShelfConnections = new HashSet<>();
        }

        return itemShelfConnections;
    }

    public void addItemShelfConnection(ItemShelfConnection itemShelfConnection) {
        if(!getItemShelfConnections().contains(itemShelfConnection)) {
            itemShelfConnections.add(itemShelfConnection);
        }

        itemShelfConnection.setItem(this);
    }

    public void setItemShelfConnections(Set<ItemShelfConnection> itemShelfConnections) {
        this.itemShelfConnections = itemShelfConnections;
    }
}

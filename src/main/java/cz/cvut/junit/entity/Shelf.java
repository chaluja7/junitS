package cz.cvut.junit.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Maso
 * @author jakubchalupa
 * @since 19.04.16
 */
@Entity
@Table(name = "shelfs")
@NamedQueries({
    @NamedQuery(name = "Shelf.findByNumberAndBoxNumber", query = "FROM Shelf s WHERE s.shelfNumber = :shelfNumber AND s.box.boxNumber = :boxNumber")
})
public class Shelf extends AbstractEntity {

    private static final long serialVersionUID = -4658382458920361450L;

    @Column(nullable = false)
    private String shelfNumber;

    @Column(nullable = false)
    private Integer capacity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "boxId")
    private Box box;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "item")
    private Set<ItemShelfConnection> itemShelfConnections;

    public String getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(String shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
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

        itemShelfConnection.setShelf(this);
    }

    public void setItemShelfConnections(Set<ItemShelfConnection> itemShelfConnections) {
        this.itemShelfConnections = itemShelfConnections;
    }
}

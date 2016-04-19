package cz.cvut.junit.entity;

import javax.persistence.*;

/**
 * Maso
 * @author jakubchalupa
 * @since 19.04.16
 */
@Entity
@Table(name = "itemShelfs")
@NamedQueries({
    @NamedQuery(name = "ItemShelfConnection.findByShelfNumber", query = "FROM ItemShelfConnection isc WHERE isc.shelf.shelfNumber = :shelfNumber"),
    @NamedQuery(name = "ItemShelfConnection.findByItemType", query = "FROM ItemShelfConnection isc WHERE isc.item.type = :type")
})
public class ItemShelfConnection extends AbstractEntity {

    private static final long serialVersionUID = -2259763967741085136L;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "itemId")
    private Item item;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "shelfId")
    private Shelf shelf;

    @Column(nullable = false)
    private Integer count;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}

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
@Table(name = "boxes")
@NamedQueries({
    @NamedQuery(name = "Box.findByNumber", query = "FROM Box b WHERE b.boxNumber = :boxNumber")
})
public class Box extends AbstractEntity {

    private static final long serialVersionUID = -8272277429572589853L;

    @Column(nullable = false, unique = true)
    private Long boxNumber;

    @Column
    @Enumerated(EnumType.STRING)
    private CoolingType coolingType;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "box")
    private Set<Shelf> shelfs;

    public Long getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Long boxNumber) {
        this.boxNumber = boxNumber;
    }

    public CoolingType getCoolingType() {
        return coolingType;
    }

    public void setCoolingType(CoolingType coolingType) {
        this.coolingType = coolingType;
    }

    public Set<Shelf> getShelfs() {
        if(shelfs == null) {
            shelfs = new HashSet<>();
        }
        return shelfs;
    }

    public void addShelf(Shelf shelf) {
        if(getShelfs().contains(shelf)) {
            getShelfs().add(shelf);
        }

        shelf.setBox(this);
    }

    public void setShelfs(Set<Shelf> shelfs) {
        this.shelfs = shelfs;
    }
}

package cz.cvut.junit.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author jakubchalupa
 * @since 17.03.16
 */
@Entity
@Table(name = "roles", uniqueConstraints = @UniqueConstraint(columnNames = {"type"}))
public class Role extends AbstractEntity {

    public Role() {

    }

    public Role(Type type) {
        this.type = type;
    }

    public enum Type {
        ADMIN, USER
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Person> persons;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    public Type getType() {
        return type;
    }

    public void getType(Type type) {
        this.type = type;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;
        return type == role.type;

    }

    @Override
    public int hashCode() {
        return type.toString().hashCode();
    }

    @Override
    public String toString() {
        return "Role{" +
                "type=" + type +
                '}';
    }
}

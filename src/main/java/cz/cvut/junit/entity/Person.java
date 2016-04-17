package cz.cvut.junit.entity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author jakubchalupa
 * @since 17.03.16
 */
@Entity
@Table(name = "persons")
public class Person extends AbstractEntity {

    private static final long serialVersionUID = -6719668226224017418L;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    @Size(max = 255)
    private String name;

    @Column(nullable = false)
    @Size(max = 255)
    private String surname;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}

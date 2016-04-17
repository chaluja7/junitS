package cz.cvut.junit.service;

import cz.cvut.junit.entity.Person;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jakubchalupa
 * @since 19.03.16
 */
public class PersonServiceTest extends AbstractServiceTest {

    @Autowired
    protected PersonService personService;

    @Test
    public void testPersonCRUD() {
        final String email = "aaa@bb.cz";
        final String name = "jmeno";
        final String surname = "prijmeni";

        Person person = getPerson(email, name, surname);
        personService.persistPerson(person);

        Person retrievedPerson = personService.findPerson(person.getId());
        Assert.assertNotNull(retrievedPerson);
        Assert.assertEquals(email, retrievedPerson.getEmail());
        Assert.assertEquals(name, retrievedPerson.getName());
        Assert.assertEquals(surname, retrievedPerson.getSurname());

        final String newName = "jmeno2";
        retrievedPerson.setName(newName);

        personService.mergePerson(retrievedPerson);
        retrievedPerson = personService.findPerson(person.getId());
        Assert.assertNotNull(retrievedPerson);
        Assert.assertEquals(newName, retrievedPerson.getName());

        personService.deletePerson(person.getId());
        Assert.assertNull(personService.findPerson(person.getId()));
    }

    public static Person getPerson(String email, String name, String surname) {
        Person person = new Person();
        person.setEmail(email);
        person.setName(name);
        person.setSurname(surname);

        return person;
    }

}

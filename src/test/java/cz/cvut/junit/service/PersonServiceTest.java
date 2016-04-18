package cz.cvut.junit.service;

import cz.cvut.junit.entity.Person;
import cz.cvut.junit.entity.Role;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
        Set<Role> roles = new HashSet<>(Arrays.asList(new Role(Role.Type.ADMIN),new Role(Role.Type.USER)));

        Person person = getPerson(email, name, surname,roles);
        personService.persistPerson(person);

        Person retrievedPerson = personService.findPerson(person.getId());
        Assert.assertNotNull(retrievedPerson);
        Assert.assertEquals(email, retrievedPerson.getEmail());
        Assert.assertEquals(name, retrievedPerson.getName());
        Assert.assertEquals(surname, retrievedPerson.getSurname());
        Iterator<Role> roleIterator = retrievedPerson.getRoles().iterator();
        while (roleIterator.hasNext()) {
            Assert.assertEquals(true,roles.contains(roleIterator.next()));
        }
        Assert.assertEquals(roles.size(),retrievedPerson.getRoles().size());

        final String newName = "jmeno2";
        retrievedPerson.setName(newName);
        System.out.println(retrievedPerson.getRoles().remove(new Role(Role.Type.ADMIN)));

        personService.mergePerson(retrievedPerson);
        retrievedPerson = personService.findPerson(person.getId());
        Assert.assertNotNull(retrievedPerson);
        Assert.assertEquals(newName, retrievedPerson.getName());
        Assert.assertEquals(1,retrievedPerson.getRoles().size());
        Assert.assertEquals(true,retrievedPerson.getRoles().contains(new Role(Role.Type.USER)));

        personService.deletePerson(person.getId());
        Assert.assertNull(personService.findPerson(person.getId()));
    }

    public static Person getPerson(String email, String name, String surname, Set<Role> roles) {
        Person person = new Person();
        person.setEmail(email);
        person.setName(name);
        person.setSurname(surname);
        person.setRoles(roles);
        return person;
    }

}

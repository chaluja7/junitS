package cz.cvut.junit.web.controller;

import cz.cvut.junit.entity.Person;
import cz.cvut.junit.service.PersonService;
import cz.cvut.junit.web.controller.exception.BadRequestException;
import cz.cvut.junit.web.controller.exception.ResourceNotFoundException;
import cz.cvut.junit.web.wrapper.PersonWrapper;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jakubchalupa
 * @since 20.03.16
 */
@RestController
public class PersonController {

    @Autowired
    protected PersonService personService;

    @RequestMapping(value = "/persons/all", method = RequestMethod.GET)
    public List<PersonWrapper> getPersons() {
        List<PersonWrapper> personWrappers = new ArrayList<>();
        for (Person person : personService.findAllPersons()) {
            personWrappers.add(getPersonWrapperFromPerson(person));
        }

        return personWrappers;
    }

    @RequestMapping(value = "/persons/{personId}", method = RequestMethod.GET)
    public PersonWrapper getPerson(@PathVariable Long personId) {
        PersonWrapper personWrapper = getPersonWrapperFromPerson(personService.findPerson(personId));
        if(personWrapper == null) {
            throw new ResourceNotFoundException();
        }

        return personWrapper;
    }

    @RequestMapping(value = "/persons/create", method = RequestMethod.POST)
    public ResponseEntity<String> doCreateOrder(@RequestBody PersonWrapper personWrapper) {
        if(personWrapper == null) {
            throw new BadRequestException();
        }

        try {
            personService.persistPerson(getPersonFromPersonWrapper(personWrapper));
        } catch (ConstraintViolationException e) {
            throw new BadRequestException();
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private PersonWrapper getPersonWrapperFromPerson(Person person) {
        if(person == null) return null;

        PersonWrapper wrapper = new PersonWrapper();
        wrapper.setEmail(person.getEmail());
        wrapper.setName(person.getName());
        wrapper.setSurname(person.getSurname());

        return wrapper;
    }

    private Person getPersonFromPersonWrapper(PersonWrapper wrapper) {
        if(wrapper == null) return null;

        Person person = new Person();
        person.setEmail(wrapper.getEmail());
        person.setName(wrapper.getName());
        person.setSurname(wrapper.getSurname());

        return person;
    }

}

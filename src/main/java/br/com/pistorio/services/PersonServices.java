package br.com.pistorio.services;

import br.com.pistorio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding all Person!");

        List<Person> persons = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person findById(String id) {
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("João Victor");
        person.setLastName("Pistorio");
        person.setAddress("123 Main St");
        person.setGender("Male");

        return person;
    }

    public Person create(Person person) {
        logger.info("Create one Person!");

        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one Person!");

        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one Person!");
    }

    private Person mockPerson(int i) {
        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Pessoa " + i);
        person.setLastName("Sobrenome");
        person.setAddress("Endereço");
        person.setGender("Gênero");

        return person;
    }
}

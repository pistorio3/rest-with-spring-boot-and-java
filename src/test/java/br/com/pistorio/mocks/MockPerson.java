package br.com.pistorio.mocks;

import br.com.pistorio.dto.PersonDTOv1;
import br.com.pistorio.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {
    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonDTOv1 mockDTO() {
        return mockDTO(0);
    }

    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) { persons.add(mockEntity(i)); }
        return persons;
    }

    public List<PersonDTOv1> mockDTOList() {
        List<PersonDTOv1> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) { persons.add(mockDTO(i)); }
        return persons;
    }

    public Person mockEntity(Integer number) {
        Person person = new Person();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public PersonDTOv1 mockDTO(Integer number) {
        PersonDTOv1 person = new PersonDTOv1();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }
}
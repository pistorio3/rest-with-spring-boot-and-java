package br.com.pistorio.mapper;

import br.com.pistorio.dto.PersonDTOv2;
import br.com.pistorio.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {

    public PersonDTOv2 convertEntityToDTO(Person person) {
        PersonDTOv2 dto =new PersonDTOv2();

        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthDay(person.getBirthDay());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());

        return  dto;
    }

    public Person convertDTOToEntity(PersonDTOv2 person) {
        Person entity = new Person();

        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setBirthDay(person.getBirthDay());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return entity;
    }
}

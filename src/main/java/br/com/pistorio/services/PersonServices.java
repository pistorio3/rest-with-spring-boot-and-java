package br.com.pistorio.services;

import br.com.pistorio.dto.PersonDTOv1;
import br.com.pistorio.dto.PersonDTOv2;
import br.com.pistorio.exception.ResourceNotFoundException;
import br.com.pistorio.mapper.PersonMapper;
import br.com.pistorio.model.Person;
import br.com.pistorio.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.pistorio.mapper.ObjectMapper.parseListObjects;
import static br.com.pistorio.mapper.ObjectMapper.parseObject;

@Service
public class PersonServices {
    private final Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;

    public List<PersonDTOv1> findAll() {
        logger.info("Finding all Person!");

        return parseListObjects(personRepository.findAll(), PersonDTOv1.class);
    }

    public PersonDTOv1 findById(Long id) {
        logger.info("Finding one Person!");

        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        return parseObject(entity, PersonDTOv1.class);
    }

    public PersonDTOv1 create(PersonDTOv1 person) {
        logger.info("Create one Person!");
        var entity = parseObject(person, Person.class);
        return parseObject(personRepository.save(entity), PersonDTOv1.class);
    }

    public PersonDTOv2 createV2(Person person) {
        logger.info("Create one Person! v2");
        var entity = personMapper.convertDTOToEntity(person);
        return personMapper.convertEntityToDTO(personRepository.save(entity));
    }

    public PersonDTOv1 update(PersonDTOv1 person) {
        logger.info("Updating one Person!");

        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(personRepository.save(entity), PersonDTOv1.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");

        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        personRepository.delete(entity);
    }
}

package com.fiap.java.techchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fiap.java.techchallenge.controller.criterias.PersonCriteria;
import com.fiap.java.techchallenge.controller.dto.PersonDTO;
import com.fiap.java.techchallenge.entity.Address;
import com.fiap.java.techchallenge.entity.Person;
import com.fiap.java.techchallenge.entity.Relationship;
import com.fiap.java.techchallenge.entity.User;
import com.fiap.java.techchallenge.repository.PersonRepository;
import com.fiap.java.techchallenge.repository.RelationshipRepository;
import com.fiap.java.techchallenge.repository.UserRepository;

@Service
public class PeopleService {

  @Autowired
  private PersonRepository peopleRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RelationshipRepository relationshipRepository;

  @Autowired
  private AddressService addressService;

  public List<Person> getAll(PersonCriteria criteira) {
    Specification<Person> specification = criteira.toSpecification();
    return this.peopleRepository.findAll(specification);
  }

  public Person getById(Long id) {
    return this.peopleRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Person Not Found!"));
  }

  public Person create(Long userId, PersonDTO personDTO) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new IllegalArgumentException("User Not Found!"));

    Address address = addressService.getById(userId);

    Person person = personDTO.toPerson();
    person.setUser(user);
    person.setAddress(address);

    return this.peopleRepository.save(person);
  }

  public void update(Long id, PersonDTO personDTO) {
    this.getById(id); // checks if exists
    addressService.getById(personDTO.getAddressId()); // checks if exists address

    Person person = personDTO.toPerson();
    person.setId(id);
    this.peopleRepository.save(person);
  }

  public void delete(Long id) {
    this.getById(id); // checks if exists
    this.peopleRepository.deleteById(id);
  }

  public Relationship createRelationship(Long personId, Long relativeId, String relation) {
    Person person = this.getById(personId);
    Person relative = this.getById(relativeId);

    Relationship relationship = new Relationship();
    relationship.setPerson(person);
    relationship.setRelative(relative);
    relationship.setRelation(relation);

    return relationshipRepository.save(relationship);
  }

}

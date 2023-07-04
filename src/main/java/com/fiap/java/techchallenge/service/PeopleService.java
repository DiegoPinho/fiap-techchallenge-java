package com.fiap.java.techchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.java.techchallenge.controller.dto.PersonDTO;
import com.fiap.java.techchallenge.domain.Person;
import com.fiap.java.techchallenge.repository.PeopleRepository;

@Service
public class PeopleService {

  @Autowired
  private PeopleRepository repository;

  public List<Person> getAll() {
    return this.repository.getAll();
  }

  public Person getById(Integer id) {
    Person person = this.repository.getById(id);
    if (person == null) {
      throw new IllegalArgumentException("Person Not Found!");
    }

    return person;
  }

  public void create(PersonDTO personDTO) {
    Person person = personDTO.toPerson();
    this.repository.save(person);
  }

  public void update(Integer id, PersonDTO personDTO) {
    this.getById(id); // checks if exists
    this.repository.update(id, personDTO.toPerson());
  }

  public void delete(Integer id) {
    this.getById(id); // checks if exists
    this.repository.delete(id);
  }

}

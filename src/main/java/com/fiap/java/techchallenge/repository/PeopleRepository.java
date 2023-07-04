package com.fiap.java.techchallenge.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fiap.java.techchallenge.domain.Person;

@Repository
public class PeopleRepository {

  private List<Person> people;

  public PeopleRepository() {
    this.people = new ArrayList<Person>();
  }

  public List<Person> getAll() {
    return this.people;
  }

  public Person getById(Integer id) {
    for (Person person : people) {
      if (person.getId().equals(id)) {
        return person;
      }
    }

    return null;
  }

  public Person save(Person person) {
    this.people.add(person);
    return person;
  }

  public void update(Integer id, Person updatedPerson) {
    for (Person person : people) {
      if (person.getId().equals(id)) {
        person.setBirthDate(updatedPerson.getBirthDate());
        person.setGender(updatedPerson.getGender());
        person.setName(updatedPerson.getName());
        person.setRelationship(updatedPerson.getRelationship());
        break;
      }
    }
  }

  public void delete(Integer id) {
    Person personToRemove = null;
    for (Person person : this.people) {
      if (person.getId().equals(id)) {
        personToRemove = person;
      }
    }

    if (personToRemove != null) {
      this.people.remove(personToRemove);
    }
  }

}

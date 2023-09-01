package com.fiap.java.techchallenge.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.java.techchallenge.controller.criterias.PersonCriteria;
import com.fiap.java.techchallenge.controller.dto.PersonDTO;
import com.fiap.java.techchallenge.controller.dto.RelationshipDTO;
import com.fiap.java.techchallenge.entity.Person;
import com.fiap.java.techchallenge.entity.Relationship;
import com.fiap.java.techchallenge.service.PeopleService;
import com.fiap.java.techchallenge.utils.DTOValidator;

@RestController
@RequestMapping("/people")
public class PersonController {

  @Autowired
  private PeopleService service;

  @Autowired
  private DTOValidator validator;

  @GetMapping
  public ResponseEntity<?> getAll(PersonCriteria criteira) {
    List<Person> person = this.service.getAll(criteira);
    return ResponseEntity.ok().body(person);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable("id") Long id) {
    try {
      Person person = this.service.getById(id);
      return ResponseEntity.ok().body(person);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody PersonDTO personDTO) {
    Map<Object, Object> violations = validator.check(personDTO);
    if (!violations.isEmpty()) {
      return ResponseEntity.badRequest().body(violations);
    }

    Long userId = 1L; // FIXME: this is fake for now, soon will be by authentication
    Person person = this.service.create(userId, personDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(person);
  }

  @PostMapping("/relationship")
  public ResponseEntity<?> createRelationship(@RequestBody RelationshipDTO dto) {
    try {
      Relationship relationship = this.service.createRelationship(dto.getPersonId(), dto.getRelativeId(),
          dto.getRelation());
      return ResponseEntity.status(HttpStatus.CREATED).body(relationship);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody PersonDTO personDTO, @PathVariable("id") Long id) {
    try {
      this.service.update(id, personDTO);
      return ResponseEntity.ok().body(null);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    try {
      this.service.delete(id);
      return ResponseEntity.ok().body(null);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

}

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

import com.fiap.java.techchallenge.controller.dto.PersonDTO;
import com.fiap.java.techchallenge.domain.Person;
import com.fiap.java.techchallenge.service.PeopleService;
import com.fiap.java.techchallenge.utils.DTOValidator;

@RestController
@RequestMapping("/people")
public class PeopleController {

  @Autowired
  private PeopleService service;

  @Autowired
  private DTOValidator validator;

  @GetMapping
  public ResponseEntity<?> getAll() {
    List<Person> addresses = this.service.getAll();
    return ResponseEntity.ok().body(addresses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
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

    Person person = this.service.create(personDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(person);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody PersonDTO personDTO, @PathVariable("id") Integer id) {
    try {
      this.service.update(id, personDTO);
      return ResponseEntity.ok().body(null);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
    try {
      this.service.delete(id);
      return ResponseEntity.ok().body(null);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

}

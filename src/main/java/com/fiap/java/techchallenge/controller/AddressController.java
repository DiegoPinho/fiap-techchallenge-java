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

import com.fiap.java.techchallenge.controller.criterias.AddressCriteria;
import com.fiap.java.techchallenge.controller.dto.AddressDTO;
import com.fiap.java.techchallenge.entity.Address;
import com.fiap.java.techchallenge.service.AddressService;
import com.fiap.java.techchallenge.utils.DTOValidator;

@RestController
@RequestMapping("/addresses")
public class AddressController {

  @Autowired
  private AddressService service;

  @Autowired
  private DTOValidator validator;

  @GetMapping
  public ResponseEntity<?> getAll(AddressCriteria criteria) {
    List<Address> addresses = this.service.getAll(criteria);
    return ResponseEntity.ok().body(addresses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable("id") Long id) {
    try {
      Address address = this.service.getById(id);
      return ResponseEntity.ok().body(address);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody AddressDTO addressDTO) {
    Map<Object, Object> violations = validator.check(addressDTO);
    if (!violations.isEmpty()) {
      return ResponseEntity.badRequest().body(violations);
    }

    Long userId = 1L; // FIXME: this is fake for now, soon will be by authentication
    Address address = this.service.create(userId, addressDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(address);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody AddressDTO addressDTO, @PathVariable("id") Long id) {
    try {
      this.service.update(id, addressDTO);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    try {
      this.service.delete(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

}

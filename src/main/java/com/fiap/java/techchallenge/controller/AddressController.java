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

import com.fiap.java.techchallenge.controller.dto.AddressDTO;
import com.fiap.java.techchallenge.domain.Address;
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
  public ResponseEntity<?> getAll() {
    List<Address> addresses = this.service.getAll();
    return ResponseEntity.ok().body(addresses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
    Address address = this.service.getById(id);
    return ResponseEntity.ok().body(address);
  }

  @PostMapping
  public ResponseEntity create(@RequestBody AddressDTO addressDTO) {
    Map<Object, Object> collect = validator.check(addressDTO);
    if (!collect.isEmpty()) {
      return ResponseEntity.badRequest().body(collect);
    }

    this.service.create(addressDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(null);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody AddressDTO addressDTO, @PathVariable("id") Integer id) {
    this.service.update(id, addressDTO);
    return ResponseEntity.ok().body(null);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
    this.service.delete(id);
    return ResponseEntity.ok().body(null);
  }

}

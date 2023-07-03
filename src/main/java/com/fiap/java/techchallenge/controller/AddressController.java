package com.fiap.java.techchallenge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.java.techchallenge.controller.dto.AddressDTO;

@RestController
@RequestMapping("/address")
public class AddressController {

  @PostMapping
  public ResponseEntity create(@RequestBody AddressDTO address) {
    return ResponseEntity.ok().build();
  }

}

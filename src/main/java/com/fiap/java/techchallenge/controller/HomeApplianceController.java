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

import com.fiap.java.techchallenge.controller.dto.HomeApplianceDTO;
import com.fiap.java.techchallenge.domain.HomeAppliance;
import com.fiap.java.techchallenge.service.HomeApplianceService;
import com.fiap.java.techchallenge.utils.DTOValidator;

@RestController
@RequestMapping("/appliances")
public class HomeApplianceController {

  @Autowired
  private HomeApplianceService homeApplianceService;

  @Autowired
  private DTOValidator validator;

  @GetMapping
  public ResponseEntity<?> getAll() {
    List<HomeAppliance> homeAppliances = this.homeApplianceService.getAll();
    return ResponseEntity.ok().body(homeAppliances);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
    try {
      HomeAppliance homeAppliance = this.homeApplianceService.getById(id);
      return ResponseEntity.ok().body(homeAppliance);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody HomeApplianceDTO homeApplianceDTO) {

    Map<Object, Object> violations = validator.check(homeApplianceDTO);
    if (!violations.isEmpty()) {
      return ResponseEntity.badRequest().body(violations);
    }

    HomeAppliance homeAppliance = this.homeApplianceService.create(homeApplianceDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(homeAppliance);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody HomeApplianceDTO homeApplianceDTO, @PathVariable("id") Integer id) {
    try {
      this.homeApplianceService.update(id, homeApplianceDTO);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
    try {
      this.homeApplianceService.delete(id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

}

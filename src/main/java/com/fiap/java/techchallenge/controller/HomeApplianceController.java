package com.fiap.java.techchallenge.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

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
    HomeAppliance homeAppliance = this.homeApplianceService.getById(id);
    return ResponseEntity.ok().body(homeAppliance);
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody HomeApplianceDTO homeApplianceDTO) {

    Map<Object, Object> collect = validator.check(homeApplianceDTO);
    if (!collect.isEmpty()) {
      return ResponseEntity.badRequest().body(collect);
    }

    this.homeApplianceService.create(homeApplianceDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(null);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody HomeApplianceDTO homeApplianceDTO, @PathVariable("id") Integer id) {
    this.homeApplianceService.update(id, homeApplianceDTO);
    return ResponseEntity.ok().body(null);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
    this.homeApplianceService.delete(id);
    return ResponseEntity.ok().body(null);
  }

}

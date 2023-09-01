package com.fiap.java.techchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fiap.java.techchallenge.controller.criterias.HomeApplianceCriteria;
import com.fiap.java.techchallenge.controller.dto.HomeApplianceDTO;
import com.fiap.java.techchallenge.entity.HomeAppliance;
import com.fiap.java.techchallenge.entity.User;
import com.fiap.java.techchallenge.repository.HomeApplianceRepository;
import com.fiap.java.techchallenge.repository.UserRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class HomeApplianceService {

  @Autowired
  HomeApplianceRepository repository;

  @Autowired
  private UserRepository userRepository;

  public List<HomeAppliance> getAll(HomeApplianceCriteria criteria) {
    Specification<HomeAppliance> specification = criteria.toSpecification();
    return this.repository.findAll(specification);
  }

  public HomeAppliance getById(Long id) {
    return this.repository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Home Appliance Not Found!"));
  }

  public HomeAppliance create(Long userId, HomeApplianceDTO homeApplianceDTO) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new IllegalArgumentException("User Not Found!"));

    HomeAppliance homeAppliance = homeApplianceDTO.toHomeAppliance();
    homeAppliance.setUser(user);

    return this.repository.save(homeAppliance);
  }

  @Transactional
  public void update(Long id, HomeApplianceDTO homeApplianceDTO) {
    this.getById(id); // checks if exists

    HomeAppliance updatedHomeAppliance = homeApplianceDTO.toHomeAppliance();
    updatedHomeAppliance.setId(id);
    this.repository.save(updatedHomeAppliance);
  }

  @Transactional
  public void delete(Long id) {
    this.getById(id); // checks if exists
    this.repository.deleteById(id);
  }

}

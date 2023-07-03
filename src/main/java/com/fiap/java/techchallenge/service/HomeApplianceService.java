package com.fiap.java.techchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.java.techchallenge.controller.dto.HomeApplianceDTO;
import com.fiap.java.techchallenge.domain.HomeAppliance;
import com.fiap.java.techchallenge.repository.HomeApplianceRepository;

@Service
public class HomeApplianceService {

  @Autowired
  HomeApplianceRepository repository;

  public List<HomeAppliance> getAll() {
    return this.repository.getAll();
  }

  public HomeAppliance getById(Integer id) {
    HomeAppliance homeAppliance = this.repository.getById(id);
    if (homeAppliance == null) {
      throw new IllegalArgumentException("Home Appliance Not Found!");
    }

    return homeAppliance;
  }

  public void create(HomeApplianceDTO homeApplianceDTO) {
    HomeAppliance homeAppliance = homeApplianceDTO.toHomeAppliance();
    this.repository.save(homeAppliance);
  }

  public void update(Integer id, HomeApplianceDTO homeApplianceDTO) {
    this.getById(id); // checks if exists
    this.repository.update(id, homeApplianceDTO.toHomeAppliance());
  }

  public void delete(Integer id) {
    this.getById(id);
    this.repository.delete(id);
  }

}

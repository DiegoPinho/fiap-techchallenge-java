package com.fiap.java.techchallenge.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fiap.java.techchallenge.domain.HomeAppliance;

@Repository
public class HomeApplianceRepository {

  private List<HomeAppliance> homeAppliances;

  public HomeApplianceRepository() {
    this.homeAppliances = new ArrayList<HomeAppliance>();
  }

  public List<HomeAppliance> getAll() {
    return this.homeAppliances;
  }

  public HomeAppliance getById(Integer id) {
    for (HomeAppliance homeAppliance : homeAppliances) {
      if (homeAppliance.getId().equals(id)) {
        return homeAppliance;
      }
    }

    return null;
  }

  public HomeAppliance save(HomeAppliance homeAppliance) {
    this.homeAppliances.add(homeAppliance);
    return homeAppliance;
  }

  public void update(Integer id, HomeAppliance updatedHomeAppliance) {

    for (HomeAppliance homeAppliance : homeAppliances) {
      if (homeAppliance.getId().equals(id)) {
        homeAppliance.setModel(updatedHomeAppliance.getModel());
        homeAppliance.setName(updatedHomeAppliance.getName());
        homeAppliance.setPower(updatedHomeAppliance.getPower());
        break;
      }
    }
  }

  public void delete(Integer id) {
    HomeAppliance homeApplianceToRemove = null;

    for (HomeAppliance homeAppliance : homeAppliances) {
      if (homeAppliance.getId().equals(id)) {
        homeApplianceToRemove = homeAppliance;
        break;
      }
    }

    if (homeApplianceToRemove != null) {
      homeAppliances.remove(homeApplianceToRemove);
    }
  }

}

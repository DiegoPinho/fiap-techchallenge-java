package com.fiap.java.techchallenge.domain;

import com.fiap.java.techchallenge.utils.RandomIdGenerator;

public class HomeAppliance {

  private Integer id;
  private String name;
  private String model;
  private Integer power;

  public HomeAppliance() {
    this.id = RandomIdGenerator.generateId();
  }

  public HomeAppliance(String name, String model, Integer power) {
    this();
    this.name = name;
    this.model = model;
    this.power = power;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setPower(Integer power) {
    this.power = power;
  }

  public String getName() {
    return this.name;
  }

  public Integer getId() {
    return id;
  }

  public String getModel() {
    return model;
  }

  public Integer getPower() {
    return power;
  }

}

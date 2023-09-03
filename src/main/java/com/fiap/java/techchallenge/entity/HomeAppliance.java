package com.fiap.java.techchallenge.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Table
@EqualsAndHashCode(of = { "id" })
@ToString(of = { "id" }, callSuper = true)
@Entity(name = "homeappliances")
public class HomeAppliance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String model;
  private Integer power;
  private String manufacturer;
  private Integer voltage;

  @ManyToOne
  @JoinColumn(name = "address_id")
  private Address address;

  @OneToMany(mappedBy = "homeAppliance")
  private List<Consumption> consumptions;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public HomeAppliance() {
  }

  public HomeAppliance(String name, String model, Integer power, String manufacturer, Integer voltage) {
    this.name = name;
    this.model = model;
    this.power = power;
    this.manufacturer = manufacturer;
    this.voltage = voltage;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public String getModel() {
    return model;
  }

  public Integer getPower() {
    return power;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public Integer getVoltage() {
    return voltage;
  }

  public void setVoltage(Integer voltage) {
    this.voltage = voltage;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Consumption> getConsumptions() {
    return consumptions;
  }

  public void setConsumptions(List<Consumption> consumptions) {
    this.consumptions = consumptions;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

}

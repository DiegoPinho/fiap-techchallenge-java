package com.fiap.java.techchallenge.domain;

import com.fiap.java.techchallenge.utils.RandomIdGenerator;

public class Address {

  private Integer id;
  private String street;
  private Integer number;
  private String district;
  private String city;
  private String state;

  public Address() {
    this.id = RandomIdGenerator.generateId();
  }

  public Address(String street, Integer number, String district, String city, String state) {
    this();
    this.street = street;
    this.number = number;
    this.district = district;
    this.city = city;
    this.state = state;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

}

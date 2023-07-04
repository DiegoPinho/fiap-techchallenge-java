package com.fiap.java.techchallenge.domain;

import java.time.LocalDate;

import com.fiap.java.techchallenge.utils.RandomIdGenerator;

public class Person {
  private Integer id;
  private String name;
  private LocalDate birthDate;
  private Gender gender;
  private String relationship;

  public Person() {
    this.id = RandomIdGenerator.generateId();
  }

  public Person(String name, LocalDate birhDate, Gender gender, String relationship) {
    this();
    this.name = name;
    this.birthDate = birhDate;
    this.gender = gender;
    this.relationship = relationship;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getRelationship() {
    return relationship;
  }

  public void setRelationship(String relationship) {
    this.relationship = relationship;
  }

}

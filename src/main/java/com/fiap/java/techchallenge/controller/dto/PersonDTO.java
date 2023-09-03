package com.fiap.java.techchallenge.controller.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.java.techchallenge.entity.Person;
import com.fiap.java.techchallenge.entity.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PersonDTO {

  @JsonProperty
  @NotBlank(message = "Name is required and cannot be blank")
  private String name;

  @JsonProperty
  @NotNull(message = "BirthDate is required and cannot be blank")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthDate;

  @JsonProperty
  @NotNull(message = "Gender is required and cannot be blank")
  private Gender gender;

  @JsonProperty
  @NotNull(message = "AddressId is required and cannot be blank")
  private Long addressId;

  public Person toPerson() {
    return new Person(
        this.name, this.birthDate, this.gender);
  }

  public Long getAddressId() {
    return addressId;
  }

}

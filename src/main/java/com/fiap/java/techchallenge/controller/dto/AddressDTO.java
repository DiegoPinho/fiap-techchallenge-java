package com.fiap.java.techchallenge.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.java.techchallenge.domain.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AddressDTO {

  @JsonProperty
  @NotBlank(message = "Street is required and cannot be blank")
  private String street;

  @JsonProperty
  @NotNull(message = "Number is required and cannot be blank")
  @Positive(message = "Number is required and cannot be blank")
  private Integer number;

  @JsonProperty
  @NotBlank(message = "District is required and cannot be blank")
  private String district;

  @JsonProperty
  @NotBlank(message = "City is required and cannot be blank")
  private String city;

  @JsonProperty
  @NotBlank(message = "State is required and cannot be blank")
  private String state;

  public Address toAddress() {
    return new Address(this.street, this.number, this.district, this.city, this.state);
  }
}

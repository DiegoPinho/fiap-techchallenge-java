package com.fiap.java.techchallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class AddressDTO {

  @JsonProperty
  @NotBlank(message = "Street is required and cannot be blank")
  private String street;

  @JsonProperty
  @NotBlank(message = "Number is required and cannot be blank")
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
}
